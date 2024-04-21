package org.example.service;


import org.example.model.Entrenamiento;
import org.example.repository.EntrenamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrenamientoService {

    private EntrenamientoRepository entrenamientoRepository;
@Autowired
    public EntrenamientoService(EntrenamientoRepository entrenamientoRepository) {
        this.entrenamientoRepository = entrenamientoRepository;
    }

    public String registrarEntrenamiento(Entrenamiento entrenamiento){
        entrenamientoRepository.save(entrenamiento);
        return "se registro el entrenamiento";
    }
}
