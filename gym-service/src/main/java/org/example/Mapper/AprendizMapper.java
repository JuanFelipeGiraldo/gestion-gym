package org.example.Mapper;

import org.example.dto.AprendizDTO;
import org.example.dto.AprendizResponseDTO;
import org.example.dto.EntrenadorAsociadoDTO;
import org.example.model.Aprendiz;
import org.example.model.Entrenador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Configuration;

@Mapper
public interface AprendizMapper {

    AprendizMapper INSTANCE = Mappers.getMapper(AprendizMapper.class);

    @Mapping(target = "entrenador", ignore = true)
    Aprendiz aprendizDtoToAprendiz(AprendizDTO aprendizDTO);

    AprendizDTO aprendizToAprendizDto(Aprendiz aprendiz);

    @Mapping(target = "entrenadorAsociado", ignore = true)
    AprendizResponseDTO aprendizDtoToAprendizResponse(AprendizDTO aprendizDTO);

    @Mapping(target = "entrenadorAsociado", source = "entrenador")
    AprendizResponseDTO aprendizToAprendizResponse(Aprendiz aprendiz);

    default EntrenadorAsociadoDTO mapEntrenadorToEntrenadorAsociadoDTO(Entrenador entrenador) {
        EntrenadorAsociadoDTO entrenadorAsociado = EntrenadorMapper.INSTANCE.entrenadorToEntrenadorAsociado(entrenador);
        return entrenadorAsociado;
    }

    default Aprendiz mapAprendizDtoToAprendiz(AprendizDTO aprendizDTO, Entrenador entrenador) {
        Aprendiz aprendiz = aprendizDtoToAprendiz(aprendizDTO);
        aprendiz.setEntrenador(entrenador);
        return aprendiz;
    }

    default AprendizResponseDTO mapAprendizDtoToAprendizResponse(AprendizDTO aprendizDTO, Entrenador entrenador) {
        AprendizResponseDTO aprendizResponse = aprendizDtoToAprendizResponse(aprendizDTO);
        aprendizResponse.setEntrenadorAsociado( mapEntrenadorToEntrenadorAsociadoDTO(entrenador) );
        return aprendizResponse;
    }

}
