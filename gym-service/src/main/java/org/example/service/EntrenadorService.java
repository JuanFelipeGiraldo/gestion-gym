package org.example.service;

import org.example.model.Entrenador;
import org.example.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrenadorService {
    @Autowired
     private EntrenadorRepository entrenadorRepository;

     public String crearEntrenador(Entrenador entrenador){
         entrenadorRepository.save(entrenador);
         return "exitoso";
     }
}
