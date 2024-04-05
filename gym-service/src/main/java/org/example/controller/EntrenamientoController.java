package org.example.controller;

import org.example.model.Entrenamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntrenamientoController {

    private final Entrenamiento entrenamiento;

    @Autowired
    public EntrenamientoController(Entrenamiento entrenamiento) {
        this.entrenamiento = entrenamiento;
    }
}
