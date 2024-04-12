package org.example.service;

import org.example.model.Entrenador;
import org.example.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrenadorService {

     private EntrenadorRepository entrenadorRepository;

    @Autowired
    public EntrenadorService(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }

    public Entrenador crearEntrenador(Entrenador entrenador){
        entrenadorRepository.save(entrenador);
        return entrenador;
    }
}
