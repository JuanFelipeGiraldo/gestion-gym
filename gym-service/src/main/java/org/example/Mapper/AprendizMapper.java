package org.example.Mapper;

import org.example.dto.AprendizDTO;
import org.example.dto.AprendizResponseDTO;
import org.example.model.Aprendiz;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Configuration;

@Mapper
public interface AprendizMapper {

    AprendizMapper INSTANCE = Mappers.getMapper(AprendizMapper.class);

    Aprendiz aprendizDtoToAprendiz(AprendizDTO aprendizDTO);

    AprendizDTO aprendizToAprendizDto(Aprendiz aprendiz);

    AprendizResponseDTO aprendizDtoToAprendizResponse(AprendizDTO aprendizDTO);


}
