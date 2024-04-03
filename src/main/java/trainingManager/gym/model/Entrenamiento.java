package trainingManager.gym.model;

import java.util.Date;

public class Entrenamiento {
//relacionar con id y tiempo(fecha)

    private String identificacion;// identificacion del aprendiz
    private Date fecha;
    private String categoriaEntrenamiento ; // pierna ,tren superior cardio
    private String tiempo;

    public Entrenamiento(String categoriaEntrenamiento, String tiempo) {
        this.categoriaEntrenamiento = categoriaEntrenamiento;
        this.tiempo = tiempo;
    }
}
