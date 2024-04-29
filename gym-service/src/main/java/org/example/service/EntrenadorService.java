package org.example.service;

import org.example.Mapper.EntrenadorMapper;
import org.example.config.SecurityConfig;
import org.example.dto.EntrenadorDTO;
import org.example.dto.EntrenadorResponseDTO;
import org.example.exception.GymDetailsException;
import org.example.exception.GymRequestException;
import org.example.model.Entrenador;
import org.example.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntrenadorService {

     private EntrenadorRepository entrenadorRepository;
    private SecurityConfig securityConfig;

    @Autowired
    public EntrenadorService(EntrenadorRepository entrenadorRepository, SecurityConfig securityConfig) {
        this.entrenadorRepository = entrenadorRepository;
        this.securityConfig = securityConfig;
    }

    public void crearEntrenador(EntrenadorDTO entrenadorDTO) throws GymRequestException {

        Optional<Entrenador> entrenador = entrenadorRepository
                .findById(entrenadorDTO.getIdentificacion());

        if (entrenador.isPresent()) {
            throw new GymRequestException("El entrenador ya existe",
                    new GymDetailsException("El entrenador con id " + entrenadorDTO.getIdentificacion() + " ya existe.",
                    HttpStatus.CONFLICT));
        }
        entrenadorDTO.setPassword(securityConfig.passwordEncoder().encode(entrenadorDTO.getPassword()));
        entrenadorRepository.save(EntrenadorMapper.INSTANCE
                .entrenadorDtoToEntrenador(entrenadorDTO));

        EntrenadorMapper.INSTANCE.
                entrenadorDtoToEntrenadorResponse(entrenadorDTO);
    }

    public List<EntrenadorResponseDTO> consultarEntrenadores(){

        List<Entrenador> entrenadores = entrenadorRepository.findAll();

        List<EntrenadorResponseDTO> entrenadoresResponse = entrenadores.stream()
                .map(EntrenadorMapper.INSTANCE::entrenadorToEntrenadorResponse)
                .collect(Collectors.toList());
        return entrenadoresResponse;
    }

    public EntrenadorResponseDTO consultarEntrenadorPorId(int identificacion) throws GymRequestException {

        Optional<Entrenador> entrenador = entrenadorRepository
                .findById(identificacion);
        if (entrenador.isEmpty()) {
            throw new GymRequestException("Identidifacion de Entrenador no existe",
                    new GymDetailsException("El entrenador con id " + identificacion + " no se encuentra registrado",
                            HttpStatus.NOT_FOUND));
        }
        return EntrenadorMapper.INSTANCE.entrenadorToEntrenadorResponse(entrenador.get());
    }

    public EntrenadorResponseDTO actualizarEntrenador(EntrenadorDTO entrenadorDTO) throws GymRequestException {

        Optional<Entrenador> entrenador = entrenadorRepository
                .findById(entrenadorDTO.getIdentificacion());

        if (entrenador.isEmpty()) {
            throw new GymRequestException("No se encontró el aprendiz.",
                    new GymDetailsException("El aprendiz no está registrado",
                            HttpStatus.NOT_FOUND));
        }
        entrenadorDTO.setPassword(securityConfig.passwordEncoder().encode(entrenadorDTO.getPassword()));
        entrenadorRepository.save( EntrenadorMapper.INSTANCE
                .entrenadorDtoToEntrenador(entrenadorDTO));

        return EntrenadorMapper.INSTANCE.entrenadorDtoToEntrenadorResponse(entrenadorDTO);

    }

    public void eliminarEntrenadorPorId(int identificacion) throws GymRequestException {

        Optional<Entrenador> entrenador = entrenadorRepository
                .findById(identificacion);
        if (entrenador.isEmpty()) {
            throw new GymRequestException("No se encontró el entrenador.",
                    new GymDetailsException("El entrenador con id " + identificacion + " no está registrado",
                            HttpStatus.NOT_FOUND));
        }
        entrenadorRepository.deleteById(identificacion);
    }
}
