package org.example.service;



import org.example.comunication.ComunicationService;
import org.example.exception.GymRequestException;
import org.example.model.Aprendiz;
import org.example.model.Entrenador;
import org.example.model.Entrenamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EntrenamientoService {
    private ComunicationService comumicationService;
    private AprendizService aprendizService;
    private EntrenadorService entrenadorService;
    private Aprendiz aprendiz;
    private Entrenador entrenador;

    @Autowired
    public EntrenamientoService(ComunicationService comumicationServiceImp, AprendizService aprendizService, EntrenadorService entrenadorService) {
        this.comumicationService = comumicationServiceImp;
        this.aprendizService = aprendizService;
        this.entrenadorService = entrenadorService;
    }

    public String registrarEntrenamiento(Entrenamiento entrenamiento) throws GymRequestException {
        aprendiz = aprendizService.traerAprendizId(entrenamiento.getAprendiz_id());
        entrenador = aprendiz.getEntrenador();
        entrenamiento.setNombreAprendiz(aprendiz.getNombre());
        entrenamiento.setNombreEntrenador(entrenador.getNombre());
        return comumicationService.registrarEntrenamiento(entrenamiento);
    }

    public String traerReporteEntrenamientos (int aprendizId, int mes,int anio) throws GymRequestException {
        aprendiz = aprendizService.traerAprendizId(aprendizId);
        return comumicationService.generarReporteMensual(aprendizId,mes,anio);

    }
}
