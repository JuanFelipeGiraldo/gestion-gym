package org.example.dto;

import java.util.Date;

public class AprendizRequest {

    private int identificacion; // Identificador único del aprendiz.
    private String nombre; //completo del aprendiz.
    private String correo;// Dirección de correo electrónico del aprendiz para comunicación.
    private String password; // Contraseña para acceder al perfil del aprendiz.
    private Date cumpleanos;// Fecha de nacimiento del aprendiz.
    private String genero;//nero del aprendiz (masculino, femenino, otro).
    private String objetivoEntrenamiento; // Objetivo principal del aprendiz (por ejemplo, perder peso, masa muscular, mejorar la resistencia, etc.).
    private String condicionFisica;// Nivel de condición física actual del aprendiz (principiante,intermedio, avanzado).
    private int identificadorEntrenador;

    public AprendizRequest(int identificacion, String nombre, String correo, String password, Date cumpleanos, String genero, String objetivoEntrenamiento, String condicionFisica, int identificadorEntrenador) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.cumpleanos = cumpleanos;
        this.genero = genero;
        this.objetivoEntrenamiento = objetivoEntrenamiento;
        this.condicionFisica = condicionFisica;
        this.identificadorEntrenador = identificadorEntrenador;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCumpleanos() {
        return cumpleanos;
    }

    public void setCumpleanos(Date cumpleanos) {
        this.cumpleanos = cumpleanos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getObjetivoEntrenamiento() {
        return objetivoEntrenamiento;
    }

    public void setObjetivoEntrenamiento(String objetivoEntrenamiento) {
        this.objetivoEntrenamiento = objetivoEntrenamiento;
    }

    public String getCondicionFisica() {
        return condicionFisica;
    }

    public void setCondicionFisica(String condicionFisica) {
        this.condicionFisica = condicionFisica;
    }

    public int getIdentificadorEntrenador() {
        return identificadorEntrenador;
    }

    public void setIdentificadorEntrenador(int identificadorEntrenador) {
        this.identificadorEntrenador = identificadorEntrenador;
    }
}
