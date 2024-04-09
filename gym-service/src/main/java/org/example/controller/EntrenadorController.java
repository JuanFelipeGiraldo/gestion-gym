package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.example.model.Aprendiz;
import org.example.model.Entrenador;
import org.example.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
//@Api(value = "Entrenador", description = "Controller Entrenador")
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    @Autowired
    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @PostMapping("/entrenador")
    /*@ApiOperation(value = "Crear un entrenador", notes = "Crear un nuevo entrenador en la base de datos SQL.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Entrenador creado exitosamente."),
            @ApiResponse(code = 400, message = "Error de usuario. La solicitud es incorrecta"),
            @ApiResponse(code = 500, message = "Error interno del servidor.")
    })*/

    public Entrenador crearEntrenador(@RequestBody Entrenador entrenador){
        entrenadorService.crearEntrenador(entrenador);
        return entrenador;
    }


}
