package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.example.model.Aprendiz;
import org.example.service.AprendizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
//@Api(value="Aprendiz", description = "Controller Aprendiz")
public class AprendizController {

    private final AprendizService aprendizService;

    @Autowired
    public AprendizController(AprendizService aprendizService) {
        this.aprendizService = aprendizService;
    }

    @PostMapping("/aprendiz")
  /*  @ApiOperation(value = "Crear un nuevo aprendiz", notes = "Crea un nuevo aprendiz en la base de datos SQL.")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Aprendiz creado exitosamente."),
            @ApiResponse(code = 400, message = "Error de usuario. La solicitud es incorrecta"),
            @ApiResponse(code = 500, message = "Error interno del servidor.")
    })*/

    public Aprendiz crearAprendiz(@RequestBody Aprendiz aprendiz){
        aprendizService.crearAprendiz(aprendiz);
        return aprendiz;
    }



}
