package org.example.model;

import org.springframework.stereotype.Service;

public class Entrenador {

    private Integer identificacion;
    private String nombre;
    private String email;
    private String password;
    private String especialidad;
    private String anios_experiencia;
    private String certificaciones;

    public Entrenador(Integer identificacion, String nombre, String email, String password, String especialidad, String anios_experiencia, String certificaciones) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.especialidad = especialidad;
        this.anios_experiencia = anios_experiencia;
        this.certificaciones = certificaciones;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getAnios_experiencia() {
        return anios_experiencia;
    }

    public void setAnios_experiencia(String anios_experiencia) {
        this.anios_experiencia = anios_experiencia;
    }

    public String getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(String certificaciones) {
        this.certificaciones = certificaciones;
    }
}
