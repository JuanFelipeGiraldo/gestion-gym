package org.example.service;

import org.example.exception.GymDetailsException;
import org.example.exception.GymRequestException;
import org.example.model.Entrenador;
import org.example.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntrenadorService {

     private EntrenadorRepository entrenadorRepository;

    @Autowired
    public EntrenadorService(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }

    public String crearEntrenador(Entrenador entrenador){
        entrenadorRepository.save(entrenador);
        return "Se creo entrenador";
    }

    public Entrenador consultarEntrenadorPorId(int identificacion) throws GymRequestException {

        // Optional class: su objetivo es evitar un nullPointerException, objetos nulos
        Optional<Entrenador> entrenadorEncontrado = entrenadorRepository.findById(identificacion);
        if (entrenadorEncontrado.isEmpty()) {
            throw new GymRequestException("Identidifacion de Entrenador no existe",
                    new GymDetailsException("El entrenador con id " + identificacion + " no se encuentra registrado",
                            HttpStatus.NOT_FOUND));
        }
        return entrenadorEncontrado.get();
    }
}
