package org.example.service;

import org.example.model.Aprendiz;
import org.example.repository.AprendizRepository;
import org.springframework.stereotype.Service;

@Service
public class AprendizService {

    private AprendizRepository aprendizRepository;

    public String crearAprendiz(Aprendiz aprendiz){
        aprendizRepository.save(aprendiz);
        return "secreo Aprendiz";
    }
}
