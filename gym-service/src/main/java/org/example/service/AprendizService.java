package org.example.service;

import org.example.Mapper.AprendizMapper;
import org.example.Mapper.EntrenadorMapper;
import org.example.dto.AprendizDTO;
import org.example.dto.AprendizResponseDTO;
import org.example.dto.EntrenadorAsociadoDTO;
import org.example.exception.GymDetailsException;
import org.example.exception.GymRequestException;
import org.example.model.Aprendiz;
import org.example.model.Entrenador;
import org.example.repository.AprendizRepository;

import org.example.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AprendizService {

    private AprendizRepository aprendizRepository;
    private EntrenadorRepository entrenadorRepository;
    private EntrenadorService entrenadorService;

    @Autowired
    public AprendizService(AprendizRepository aprendizRepository, EntrenadorRepository entrenadorRepository, EntrenadorService entrenadorService) {
        this.aprendizRepository = aprendizRepository;
        this.entrenadorRepository = entrenadorRepository;
        this.entrenadorService = entrenadorService;
    }

    public AprendizResponseDTO crearAprendiz(AprendizDTO aprendizDTO) throws GymRequestException {

        int idAprendiz = aprendizDTO.getIdentificacion();
        int idEntrenador = aprendizDTO.getIdentificacionEntrenador();
        Entrenador entrenador = entrenadorService.consultarEntrenadorPorId(idEntrenador);

        Optional<Aprendiz> aprendizBuscado = aprendizRepository.findById(idAprendiz);
        Optional<Entrenador> entrenadorBuscado = entrenadorRepository.findById(idEntrenador);

        if (aprendizBuscado.isPresent()) {
            throw new GymRequestException("El aprendiz ya existe",
                    new GymDetailsException("El aprendiz con id " + idAprendiz+ " ya se encuentra registrado",
                            HttpStatus.CONFLICT));
        }

        if (entrenadorBuscado.isEmpty()) {
            throw new GymRequestException("No se encontró el entrenador.",
                    new GymDetailsException("El entrenador con id " + idEntrenador + " no está registrado",
                            HttpStatus.NOT_FOUND));
        }

        Aprendiz aprendiz = AprendizMapper.INSTANCE.aprendizDtoToAprendiz(aprendizDTO);
        aprendiz.setEntrenador(entrenador);

        EntrenadorAsociadoDTO entrenadorAsociado = EntrenadorMapper.INSTANCE.entrenadorToEntrenadorAsociado(entrenador);

        AprendizResponseDTO aprendizResponseDto = AprendizMapper.INSTANCE.aprendizDtoToAprendizResponse(aprendizDTO);
        aprendizResponseDto.setEntrenadorAsociado(entrenadorAsociado);

        aprendizRepository.save(aprendiz);
        return aprendizResponseDto;
    }
}