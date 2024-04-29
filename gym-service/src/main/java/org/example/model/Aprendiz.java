package org.example.model;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name = "aprendices")
public class Aprendiz {
    @Id
    @Column(name = "identificacion")
    private int identificacion; // Identificador único del aprendiz.

    @Column(name = "nombre")
    private String nombre; //completo del aprendiz.
    @Column(name = "email")
    private String correo;// Dirección de correo electrónico del aprendiz para comunicación.
    @Column(name = "password")
    private String password; // Contraseña para acceder al perfil del aprendiz.
    @Column(name = "fecha_nacimiento")
    private Date cumpleanos;// Fecha de nacimiento del aprendiz.
    @Column(name = "genero")
    private String genero;//nero del aprendiz (masculino, femenino, otro).
    @Column(name = "objetivo_entrenamiento")
    private String objetivoEntrenamiento; // Objetivo principal del aprendiz (por ejemplo, perder peso, masa muscular, mejorar la resistencia, etc.).
    @Column(name = "nivel_condicion_fisica")
    private String condicionFisica;// Nivel de condición física actual del aprendiz (principiante,intermedio, avanzado).
    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;// ID del entrenador asociado al aprendiz.
    public Aprendiz() {
    }

    public Aprendiz(Entrenador entrenador, int identificacion, String nombre, String correo, String password, Date cumpleanos, String genero, String objetivoEntrenamiento, String condicionFisica) {
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

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
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

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public String toString() {
        return "Aprendiz{" +
                "identificacion=" + identificacion +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", entrenador=" + entrenador +
                '}';
    }
}
