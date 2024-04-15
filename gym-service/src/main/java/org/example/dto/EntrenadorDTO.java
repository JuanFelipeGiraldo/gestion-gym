package org.example.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EntrenadorDTO {

    @NotNull
    private int identificacion;

    @NotBlank
    private String nombre;

    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String especialidad;

    @NotNull
    private int experiencia;

    private String certificaciones;

    public EntrenadorDTO(int identificacion, String nombre, String email, String password, String especialidad, int experiencia, String certificaciones) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
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
