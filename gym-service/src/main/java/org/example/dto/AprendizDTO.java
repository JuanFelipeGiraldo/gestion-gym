package org.example.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class AprendizDTO {

    @NotNull
    private int identificacion;

    @NotBlank
    private String nombre;

    @Email
    private String correo;

    @NotBlank
    private String password;

    private Date cumpleanos;

    @NotBlank
    private String genero;

    @NotBlank
    private String objetivoEntrenamiento;

    @NotBlank
    private String condicionFisica;

    @NotNull
    private int identificadorEntrenador;

    public AprendizDTO(int identificacion, String nombre, String correo, String password, Date cumpleanos, String genero, String objetivoEntrenamiento, String condicionFisica, int identificadorEntrenador) {
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
