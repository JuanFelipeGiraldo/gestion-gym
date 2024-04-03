package trainingManager.gym.model;

import java.util.Date;

public class Aprendiz {
    private Entrenador entrenador;// ID del entrenador asociado al aprendiz.
    private String identificacion; // Identificador único del aprendiz.
    private String nombre; //completo del aprendiz.
    private String correo;// Dirección de correo electrónico del aprendiz para comunicación.
    private String password; // Contraseña para acceder al perfil del aprendiz.
    private Date cumpleanos;// Fecha de nacimiento del aprendiz.
    private String genero;//nero del aprendiz (masculino, femenino, otro).
    private String objetivoEntrenamiento; // Objetivo principal del aprendiz (por ejemplo, perder peso, masa muscular, mejorar la resistencia, etc.).
    private String condicionFisica;// Nivel de condición física actual del aprendiz (principiante,intermedio, avanzado).

    public Aprendiz(Entrenador entrenador, String identificacion, String nombre, String correo, String password, Date cumpleanos, String genero, String objetivoEntrenamiento, String condicionFisica) {
        this.entrenador = entrenador;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.cumpleanos = cumpleanos;
        this.genero = genero;
        this.objetivoEntrenamiento = objetivoEntrenamiento;
        this.condicionFisica = condicionFisica;
    }
}
