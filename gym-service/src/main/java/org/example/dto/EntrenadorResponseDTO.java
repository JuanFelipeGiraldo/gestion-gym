package org.example.dto;

public class EntrenadorResponseDTO {

    private int identificacion;
    private String nombre;
    private String email;
    private String especialidad;
    private int experiencia;
    private String certificaciones;

    public EntrenadorResponseDTO(int identificacion, String nombre, String email, String especialidad, int experiencia, String certificaciones) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.email = email;
        this.especialidad = especialidad;
        this.experiencia = experiencia;
        this.certificaciones = certificaciones;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(String certificaciones) {
        this.certificaciones = certificaciones;
    }
}
