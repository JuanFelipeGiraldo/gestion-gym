package org.example.service;

import org.example.model.Entrenador;
import org.example.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntrenadorService {
    @Autowired
     private EntrenadorRepository entrenadorRepository;

    public String crearEntrenador(Entrenador entrenador){
        entrenadorRepository.save(entrenador);
        return "Se creo entrenador";
    }
    public Entrenador obtenerEntrenadorPorId(int identificacion) {
        try {
            return entrenadorRepository.findById(identificacion).orElse(null);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
