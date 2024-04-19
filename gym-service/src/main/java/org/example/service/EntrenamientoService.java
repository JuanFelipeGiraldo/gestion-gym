package org.example.service;

import org.example.comunication.ComunicationService;
import org.example.model.Entrenamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrenamientoService {

private ComunicationService comumicationService;
    @Autowired
    public EntrenamientoService(ComunicationService comumicationService) {
        this.comumicationService = comumicationService;
    }




    public String registrarEntrenamiento(Entrenamiento entrenamiento){
        return comumicationService.registrarEntrenamiento(entrenamiento);
    }
}
