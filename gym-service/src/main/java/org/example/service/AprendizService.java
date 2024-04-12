package org.example.service;

import org.example.dto.AprendizRequest;
import org.example.model.Aprendiz;
import org.example.model.Entrenador;
import org.example.repository.AprendizRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AprendizService { @Autowired
    private AprendizRepository aprendizRepository;

    private EntrenadorService entrenadorService;
    private Entrenador entrenador;
    @Autowired
    public AprendizService(AprendizRepository aprendizRepository, EntrenadorService entrenadorService) {
        this.aprendizRepository = aprendizRepository;
        this.entrenadorService = entrenadorService;
    }

    public String crearAprendiz(AprendizRequest aprendizRequest) {
        entrenador = entrenadorService.obtenerEntrenadorPorId(aprendizRequest.getIdentificadorEntrenador());
        if (entrenador == null) {
            return "No se encontro ningun entrenador con la identificacion proporcionada ";
        } else {
            Aprendiz aprendiz = new Aprendiz(entrenador, aprendizRequest.getIdentificacion(),
                    aprendizRequest.getNombre(), aprendizRequest.getCorreo(),
                    aprendizRequest.getPassword(), aprendizRequest.getCumpleanos(),
                    aprendizRequest.getGenero(), aprendizRequest.getObjetivoEntrenamiento(),
                    aprendizRequest.getCondicionFisica());

            aprendizRepository.save(aprendiz);
            return "Se creo el aprendiz satisfactoriamente";
        }
    }
}