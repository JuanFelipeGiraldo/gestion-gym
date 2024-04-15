package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.dto.AprendizDTO;
import org.example.exception.GymRequestException;
import org.example.service.AprendizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
@Tag(name="Recurso Aprendiz")
public class AprendizController {

    private final AprendizService aprendizService;

    @Autowired
    public AprendizController(AprendizService aprendizService) {
        this.aprendizService = aprendizService;
    }

    @PostMapping("/aprendiz")
    @Operation(summary = "Crear un nuevo aprendiz", description = "Crea un nuevo aprendiz en la base de datos SQL.")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Aprendiz creado exitosamente."),
            @ApiResponse(responseCode = "400", description = "Error de usuario. La solicitud es incorrecta"),
            @ApiResponse(responseCode = "404", description = "Error de usuario. No existe el recurso solicitado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public String crearAprendiz(@RequestBody @Valid AprendizDTO aprendizDTO ) throws GymRequestException {
        return  aprendizService.crearAprendiz(aprendizDTO);
    }



}
