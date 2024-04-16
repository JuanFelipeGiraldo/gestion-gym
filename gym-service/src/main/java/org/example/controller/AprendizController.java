package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.dto.AprendizDTO;
import org.example.dto.AprendizResponseDTO;
import org.example.exception.GymRequestException;
import org.example.service.AprendizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@Tag(name = "Recurso Aprendiz")
public class AprendizController {

    private final AprendizService aprendizService;

    @Autowired
    public AprendizController(AprendizService aprendizService) {
        this.aprendizService = aprendizService;
    }

    @Operation(summary = "Crea un nuevo aprendiz", description = "Crea un nuevo aprendiz en la base de datos SQL.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aprendiz creado exitosamente."),
            @ApiResponse(responseCode = "400", description = "Error de usuario. La solicitud es incorrecta"),
            @ApiResponse(responseCode = "404", description = "Error de usuario. No existe el recurso solicitado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    @PostMapping("/aprendiz")
    public ResponseEntity<AprendizResponseDTO> crearAprendiz(@RequestBody @Valid AprendizDTO aprendizDTO) throws GymRequestException {
        AprendizResponseDTO response = aprendizService.crearAprendiz(aprendizDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Consultar todos los aprendices", description = "Consulta todos los aprendices en la base de datos SQL.")
    @GetMapping("/aprendices")
    public List<AprendizResponseDTO> consultarAprendices(){
        return aprendizService.consultarAprendices();
    }

    @Operation(summary = "Consultar un aprendiz por identificación", description = "Consulta por la identificación de un aprendiz en la base de datos SQL.")
    @GetMapping("/aprendiz/{identificacion}")
    public ResponseEntity<AprendizResponseDTO> consultarAprendizPorId(@PathVariable("identificacion") int identificacion) throws GymRequestException {
        AprendizResponseDTO response = aprendizService.consultarAprendizPorId(identificacion);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Actualizar un aprendiz", description = "Actualiza los datos de un aprendiz en la base de datos SQL.")
    @PutMapping("/aprendiz")
    public ResponseEntity<AprendizResponseDTO> actualizarAprendiz(@RequestBody AprendizDTO aprendizDTO) throws GymRequestException {
        AprendizResponseDTO response = aprendizService.actualizarAprendiz(aprendizDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Eliminar un aprendiz por identificación", description = "Elimina un aprendiz de la base de datos SQL.")
    @DeleteMapping("/aprendiz/{identificacion}")
    public ResponseEntity<String> eliminarAprendiz(@PathVariable("identificacion") int idenditifacion) throws GymRequestException {
        aprendizService.eliminarAprendizPorId(idenditifacion);
        return new ResponseEntity<>("El aprendiz se ha eliminado con éxito", HttpStatus.OK);
    }













}
