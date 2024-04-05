package org.example.controller;

import org.example.model.Aprendiz;
import org.example.model.Entrenador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class EntrenadorController {

    private final Entrenador entrenador;

    @Autowired
    public EntrenadorController(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    @PostMapping("/entrenador")
    public String crearEntrenador(@RequestBody Entrenador entrenador){
        return "";
    }


}
