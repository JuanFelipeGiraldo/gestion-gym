package org.example.dto;

import java.util.Date;

public class AprendizResponseDTO {

    private int identificacion;
    private String nombre;
    private String correo;
    private Date cumpleanos;
    private String genero;
    private String objetivoEntrenamiento;
    private String condicionFisica;
    private EntrenadorAsociadoDTO entrenadorAsociado;

    public AprendizResponseDTO(int identificacion, String nombre, String correo, Date cumpleanos, String genero, String objetivoEntrenamiento, String condicionFisica, EntrenadorAsociadoDTO entrenadorAsociado) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.correo = correo;
        this.cumpleanos = cumpleanos;
        this.genero = genero;
        this.objetivoEntrenamiento = objetivoEntrenamiento;
        this.condicionFisica = condicionFisica;
        this.entrenadorAsociado = entrenadorAsociado;
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

    public EntrenadorAsociadoDTO getEntrenadorAsociado() {
        return entrenadorAsociado;
    }

    public void setEntrenadorAsociado(EntrenadorAsociadoDTO entrenadorAsociado) {
        this.entrenadorAsociado = entrenadorAsociado;
    }
}
