package org.example.service;

import org.example.comunication.ComumicationServiceImp;
import org.example.comunication.ComunicationService;
import org.example.model.Entrenamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrenamientoService {

private ComumicationServiceImp comumicationServiceImp;
    @Autowired
    public EntrenamientoService(ComumicationServiceImp comumicationServiceImp) {
        this.comumicationServiceImp = comumicationServiceImp;
    }

    public String registrarEntrenamiento(Entrenamiento entrenamiento){
        return comumicationServiceImp.registrarEntrenamiento(entrenamiento);
    }
}
