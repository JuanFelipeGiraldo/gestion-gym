package org.example.dto;

public class EntrenadorAsociadoDTO {

    private int identificacion;
    private String nombre;

    public EntrenadorAsociadoDTO(int identificacion, String nombre) {
        this.identificacion = identificacion;
        this.nombre = nombre;
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
}
