package org.example.Mapper;

import org.example.dto.EntrenadorAsociadoDTO;
import org.example.model.Entrenador;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Configuration;

@Mapper
public interface EntrenadorMapper {

    EntrenadorMapper INSTANCE = Mappers.getMapper(EntrenadorMapper.class);

    EntrenadorAsociadoDTO entrenadorToEntrenadorAsociado(Entrenador entrenador);

}
