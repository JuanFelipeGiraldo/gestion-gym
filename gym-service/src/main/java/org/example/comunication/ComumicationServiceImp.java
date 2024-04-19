package org.example.comunication;

import org.example.model.Entrenamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComumicationServiceImp {
    private ComunicationService comunicationService;
    @Autowired
    public ComumicationServiceImp(ComunicationService comunicationService) {
        this.comunicationService = comunicationService;
    }

    public String registrarEntrenamiento(Entrenamiento entrenamiento){
        return comunicationService.registrarEntrenamiento(entrenamiento);
    }

}
