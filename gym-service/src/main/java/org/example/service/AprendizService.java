package org.example.service;

import org.example.dto.AprendizDTO;
import org.example.exception.GymRequestException;
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

    public String crearAprendiz(AprendizDTO aprendizDTO) throws GymRequestException {
        entrenador = entrenadorService.obtenerEntrenadorPorId(aprendizDTO.getIdentificadorEntrenador());
        if (entrenador == null) {
            return "No se encontro ningun entrenador con la identificacion proporcionada ";
        } else {
            Aprendiz aprendiz = new Aprendiz(entrenador, aprendizDTO.getIdentificacion(),
                    aprendizDTO.getNombre(), aprendizDTO.getCorreo(),
                    aprendizDTO.getPassword(), aprendizDTO.getCumpleanos(),
                    aprendizDTO.getGenero(), aprendizDTO.getObjetivoEntrenamiento(),
                    aprendizDTO.getCondicionFisica());

            aprendizRepository.save(aprendiz);
            return "Se creo el aprendiz satisfactoriamente";
        }
    }
}