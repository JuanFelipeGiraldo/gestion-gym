package org.example.controller;

import org.example.model.Entrenamiento;
import org.example.service.EntrenamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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


}
