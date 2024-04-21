package org.example.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.dto.AprendizDTO;
import org.example.dto.AprendizResponseDTO;
import org.example.dto.EntrenadorDTO;
import org.example.dto.EntrenadorResponseDTO;
import org.example.exception.GymRequestException;
import org.example.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@Tag(name = "Recurso Entrenador", description = "Controller Entrenador")
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    @Autowired
    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @Operation(summary = "Crear un entrenador", description = "Crear un nuevo entrenador en la base de datos SQL.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entrenador creado exitosamente."),
            @ApiResponse(responseCode = "400", description = "Error de usuario. La solicitud es incorrecta"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    @PostMapping("/entrenador")
    public ResponseEntity<EntrenadorResponseDTO> crearEntrenador(@RequestBody EntrenadorDTO entrenadorDTO) throws GymRequestException {
        EntrenadorResponseDTO response = entrenadorService.crearEntrenador(entrenadorDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Consultar todos los entrenadores", description = "Consulta todos los entrenadores en la base de datos SQL.")
    @GetMapping("/entrenadores")
    public List<EntrenadorResponseDTO> consultarEntrenadores(){
        return entrenadorService.consultarEntrenadores();
    }

    @Operation(summary = "Consultar un entrenador por identificación", description = "Consulta por la identificación de un entrenador en la base de datos SQL.")
    @GetMapping("/entrenador/{identificacion}")
    public ResponseEntity<EntrenadorResponseDTO> consultarEntrenadorPorId(@PathVariable("identificacion") int identificacion) throws GymRequestException {
        EntrenadorResponseDTO response = entrenadorService.consultarEntrenadorPorId(identificacion);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Actualizar un entrenador", description = "Actualiza los datos de un entrenador en la base de datos SQL.")
    @PutMapping("/entrenador")
    public ResponseEntity<EntrenadorResponseDTO> actualizarEntrenador(@RequestBody EntrenadorDTO entrenadorDTO) throws GymRequestException {
        EntrenadorResponseDTO response = entrenadorService.actualizarEntrenador(entrenadorDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Eliminar un entrenador por identificación", description = "Elimina un entrenador de la base de datos SQL.")
    @DeleteMapping("/entrenador/{identificacion}")
    public ResponseEntity<String> eliminarAprendiz(@PathVariable("identificacion") int idenditifacion) throws GymRequestException {
        entrenadorService.eliminarEntrenadorPorId(idenditifacion);
        return new ResponseEntity<>("El entrenador se ha eliminado con éxito", HttpStatus.OK);
    }


}
