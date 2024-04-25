package org.example.service;

import org.example.Mapper.AprendizMapper;
import org.example.Mapper.EntrenadorMapper;
import org.example.dto.AprendizDTO;
import org.example.dto.AprendizResponseDTO;
import org.example.dto.EntrenadorAsociadoDTO;
import org.example.dto.EntrenadorResponseDTO;
import org.example.exception.GymDetailsException;
import org.example.exception.GymRequestException;
import org.example.model.Aprendiz;
import org.example.model.Entrenador;
import org.example.repository.AprendizRepository;

import org.example.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AprendizService {

    private AprendizRepository aprendizRepository;
    private EntrenadorRepository entrenadorRepository;
    private EntrenadorService entrenadorService;

    @Autowired
    public AprendizService(AprendizRepository aprendizRepository, EntrenadorRepository entrenadorRepository) {
        this.aprendizRepository = aprendizRepository;
        this.entrenadorRepository = entrenadorRepository;
        this.entrenadorService = entrenadorService;
    }

    public AprendizResponseDTO crearAprendiz(AprendizDTO aprendizDTO) throws GymRequestException {

        Optional<Aprendiz> aprendiz = aprendizRepository
                .findById(aprendizDTO.getIdentificacion());
        Optional<Entrenador> entrenador = entrenadorRepository
                .findById(aprendizDTO.getIdentificacionEntrenador());

        if (aprendiz.isPresent()) {
            throw new GymRequestException("El aprendiz ya existe",
                    new GymDetailsException("El aprendiz con id " + aprendizDTO.getIdentificacion() + " ya se encuentra registrado",
                            HttpStatus.CONFLICT));
        }

        if (entrenador.isEmpty()) {
            throw new GymRequestException("No se encontró el entrenador.",
                    new GymDetailsException("El entrenador con id " + aprendizDTO.getIdentificacionEntrenador() + " no está registrado",
                            HttpStatus.NOT_FOUND));
        }
        aprendizRepository.save(AprendizMapper.INSTANCE
                .mapAprendizDtoToAprendiz( aprendizDTO, entrenador.get() ));

        AprendizResponseDTO aprendizResponse = AprendizMapper.INSTANCE
                .mapAprendizDtoToAprendizResponse( aprendizDTO, entrenador.get() );

        return aprendizResponse;
    }

    public List<AprendizResponseDTO> consultarAprendices(){
        List<Aprendiz> aprendices = aprendizRepository.findAll();
        List<AprendizResponseDTO> aprendicesResponse = aprendices.stream()
                .map(AprendizMapper.INSTANCE::aprendizToAprendizResponse)
                .collect(Collectors.toList());

        return aprendicesResponse;
    }

    public AprendizResponseDTO consultarAprendizPorId(int identificacion) throws GymRequestException {

        Optional<Aprendiz> aprendiz = aprendizRepository.findById(identificacion);
        if (aprendiz.isEmpty()) {
            throw new GymRequestException("No se encontró el aprendiz.",
                    new GymDetailsException("El aprendiz con id " + identificacion + " no está registrado",
                            HttpStatus.NOT_FOUND));
        }
        AprendizResponseDTO aprendizResponse = AprendizMapper.INSTANCE.aprendizToAprendizResponse(aprendiz.get());

        return aprendizResponse;
    }

    public AprendizResponseDTO actualizarAprendiz(AprendizDTO aprendizDTO) throws GymRequestException {

        Optional<Aprendiz> aprendiz = aprendizRepository
                .findById(aprendizDTO.getIdentificacion());
        Optional<Entrenador> entrenador = entrenadorRepository
                .findById(aprendizDTO.getIdentificacionEntrenador());

        if (aprendiz.isEmpty()) {
            throw new GymRequestException("No se encontró el aprendiz.",
                    new GymDetailsException("El aprendiz no está registrado",
                            HttpStatus.NOT_FOUND));
        }

        if (entrenador.isEmpty()) {
            throw new GymRequestException("No se encontró el entrenador.",
                    new GymDetailsException("El entrenador con id " + aprendizDTO.getIdentificacionEntrenador() +
                            " no está registrado o no está asociado al aprendiz",
                            HttpStatus.NOT_FOUND));
        }
        aprendizRepository.save(AprendizMapper.INSTANCE
                .mapAprendizDtoToAprendiz( aprendizDTO, entrenador.get() ));

        AprendizResponseDTO aprendizResponse = AprendizMapper.INSTANCE
                .mapAprendizDtoToAprendizResponse( aprendizDTO, entrenador.get() );

        return aprendizResponse;
    }

    public void eliminarAprendizPorId(int identificacion) throws GymRequestException {

        Optional<Aprendiz> aprendiz = aprendizRepository.findById(identificacion);
        if (aprendiz.isEmpty()) {
            throw new GymRequestException("No se encontró el aprendiz.",
                    new GymDetailsException("El aprendiz con id " + identificacion + " no está registrado",
                            HttpStatus.NOT_FOUND));
        }
        aprendizRepository.deleteById(identificacion);
    }

   /* public AprendizResponseDTO mapearDtoToAprendizResponse(AprendizDTO aprendizDTO, Entrenador entrenador){

        EntrenadorAsociadoDTO entrenadorAsociado = EntrenadorMapper.INSTANCE
                .entrenadorToEntrenadorAsociado(entrenador);

        AprendizResponseDTO aprendizResponseDto = AprendizMapper.INSTANCE
                .aprendizDtoToAprendizResponse(aprendizDTO);
        aprendizResponseDto.setEntrenadorAsociado(entrenadorAsociado);

        return aprendizResponseDto;
    }

    public Aprendiz mapearDtoToAprendiz(AprendizDTO aprendizDTO, Entrenador entrenador){

        Aprendiz aprendiz = AprendizMapper.INSTANCE
                .aprendizDtoToAprendiz(aprendizDTO);
        aprendiz.setEntrenador(entrenador);

        return aprendiz;
    }*/

    public Aprendiz traerAprendizId(int identificacion) throws GymRequestException {

        Optional<Aprendiz> aprendiz = aprendizRepository.findById(identificacion);
        if (aprendiz.isEmpty()) {
            throw new GymRequestException("No se encontró el aprendiz.",
                    new GymDetailsException("El aprendiz con id " + identificacion + " no está registrado",
                            HttpStatus.NOT_FOUND));
        }
        return  aprendiz.get();
    }

}