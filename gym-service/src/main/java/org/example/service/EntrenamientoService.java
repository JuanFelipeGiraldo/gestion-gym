package org.example.service;

import org.example.comunication.ComumicationServiceImp;
import org.example.comunication.ComunicationService;
import org.example.dto.AprendizResponseDTO;
import org.example.exception.GymRequestException;
import org.example.model.Aprendiz;
import org.example.model.Entrenador;
import org.example.model.Entrenamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrenamientoService {
    private ComumicationServiceImp comumicationServiceImp;
    private AprendizService aprendizService;
    private EntrenadorService entrenadorService;
    private Aprendiz aprendiz;
    private Entrenador entrenador;

    @Autowired
    public EntrenamientoService(ComumicationServiceImp comumicationServiceImp, AprendizService aprendizService, EntrenadorService entrenadorService) {
        this.comumicationServiceImp = comumicationServiceImp;
        this.aprendizService = aprendizService;
        this.entrenadorService = entrenadorService;
    }

    public String registrarEntrenamiento(Entrenamiento entrenamiento) throws GymRequestException {
        aprendiz = aprendizService.traerAprendizId(entrenamiento.getAprendiz_id());
        entrenador = entrenadorService.consultarEntrenadorPorId(aprendiz.getIdentificacion());
        entrenamiento.setNombreAprendiz(aprendiz.getNombre());
        entrenamiento.setNombreEntrenador(entrenador.getNombre());
        return comumicationServiceImp.registrarEntrenamiento(entrenamiento);
    }
}
