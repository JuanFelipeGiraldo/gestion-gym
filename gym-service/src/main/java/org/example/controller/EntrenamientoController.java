package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.exception.GymRequestException;
import org.example.model.Entrenamiento;
import org.example.service.EntrenamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@Tag(name = "Recurso Entrenamiento", description = "Controller Entrenamiento")
public class EntrenamientoController {

    private EntrenamientoService entrenamientoService;

    @Autowired
    public EntrenamientoController(EntrenamientoService entrenamientoService) {
        this.entrenamientoService = entrenamientoService;
    }
    @Operation(summary = "Registrar un Entrenamiento", description = "Crear un nuevo entrenador en la base de datos SQL.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se registro exitosamente el entrenamiento."),
            @ApiResponse(responseCode = "400", description = "Error de usuario. La solicitud es incorrecta"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    @PostMapping("/entrenamiento")
    public String registrarEntrenamiento(@RequestBody Entrenamiento entrenamiento ) throws GymRequestException {
        return entrenamientoService.registrarEntrenamiento(entrenamiento);
    }
    @Operation(summary = "Generar registro de entrenamiento", description = "se realiza la solicitudd para traer todos los reportes de entrenamientos ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reporte generado correctamente."),
            @ApiResponse(responseCode = "400", description = "Error de usuario. La solicitud es incorrecta"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    @GetMapping("/reporte/{aprendizId}/{mes}/{anio}")
    public String generarReporteMensual(@PathVariable int aprendizId, @PathVariable int mes, @PathVariable int anio) throws GymRequestException {
        return entrenamientoService.traerReporteEntrenamientos(aprendizId,mes,anio);
    }

}
