package org.example.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.model.Entrenador;
import org.example.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@Tag(name = "Entrenador", description = "Controller Entrenador")
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    @Autowired
    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @Operation(
            summary = "Crear un entrenador",
            description = "Crear un nuevo entrenador en la base de datos SQL.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entrenador creado exitosamente."),
            @ApiResponse(responseCode = "400", description = "Error de usuario. La solicitud es incorrecta"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    @PostMapping("/entrenador")
    public ResponseEntity<Entrenador> crearEntrenador(@RequestBody Entrenador entrenador){
        Entrenador crearEntrenador =  entrenadorService.crearEntrenador(entrenador);
        return new ResponseEntity<>(crearEntrenador, HttpStatus.OK);
    }


}
