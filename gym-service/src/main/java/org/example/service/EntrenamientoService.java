package org.example.service;

import org.example.comunication.ComumicationServiceImp;
import org.example.comunication.ComunicationService;
import org.example.dto.AprendizResponseDTO;
import org.example.exception.GymRequestException;
import org.example.model.Entrenamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrenamientoService {
private ComumicationServiceImp comumicationServiceImp;
private AprendizService aprendizService;
private AprendizResponseDTO aprendizdto;

    @Autowired
    public EntrenamientoService(ComumicationServiceImp comumicationServiceImp, AprendizService aprendizService) {
        this.comumicationServiceImp = comumicationServiceImp;
        this.aprendizService = aprendizService;
    }

    public String registrarEntrenamiento(Entrenamiento entrenamiento) throws GymRequestException {
        aprendizdto =aprendizService.consultarAprendizPorId(entrenamiento.getAprendiz_id());
//        if (aprendizdto == null) {
//            return "No se encontro aprendiz asociado al la identificacion dada";
//        }
        return comumicationServiceImp.registrarEntrenamiento(entrenamiento);
    }
}
