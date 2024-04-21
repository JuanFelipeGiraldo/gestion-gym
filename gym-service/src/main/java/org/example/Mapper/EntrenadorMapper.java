package org.example.Mapper;

import org.example.dto.EntrenadorAsociadoDTO;
import org.example.dto.EntrenadorDTO;
import org.example.dto.EntrenadorResponseDTO;
import org.example.model.Entrenador;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntrenadorMapper {

    EntrenadorMapper INSTANCE = Mappers.getMapper(EntrenadorMapper.class);

    EntrenadorAsociadoDTO entrenadorToEntrenadorAsociado(Entrenador entrenador);

    Entrenador entrenadorDtoToEntrenador(EntrenadorDTO entrenadorDTO);

    EntrenadorResponseDTO entrenadorDtoToEntrenadorResponse(EntrenadorDTO entrenadorDTO);

    EntrenadorResponseDTO entrenadorToEntrenadorResponse(Entrenador entrenador);
}
