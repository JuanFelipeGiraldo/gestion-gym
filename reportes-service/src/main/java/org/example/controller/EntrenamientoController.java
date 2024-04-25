package org.example.controller;

import org.example.model.Entrenamiento;
import org.example.service.EntrenamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class EntrenamientoController {

    private EntrenamientoService entrenamientoService;

    @Autowired
    public EntrenamientoController(EntrenamientoService entrenamientoService) {
        this.entrenamientoService = entrenamientoService;
    }

    @PostMapping("/entrenamiento")
    public String registrarEntrenamiento(@RequestBody Entrenamiento entrenamiento) {
        return entrenamientoService.registrarEntrenamiento(entrenamiento);
    }

    @GetMapping("/entrenamientos/{aprendizId}")
    public List<Entrenamiento> obtenerEntrenamientosPorAprendiz(@PathVariable int aprendizId) {
        return entrenamientoService.obtenerEntrenamientosPorAprendiz(aprendizId);
    }

    @GetMapping("/service/{aprendizId}/{mes}/{anio}")
    public String generarReporteMensual(@PathVariable int aprendizId, @PathVariable int mes, @PathVariable int anio) {
        return entrenamientoService.generarReporteMensual(aprendizId, mes, anio);
    }
}



