package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "entrenadores")
public class Entrenador {
    @Id
    @Column(name = "identificacion")
    private int identificacion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")

    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "especialidad")
    private String especialidad;

    @Column(name = "experiencia")
    private int experiencia;

    @Column(name = "certificaciones")
    private String certificaciones;

    @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL)
    private List<Aprendiz> aprendices;

    public Entrenador() {
    }

    public Entrenador(int identificador, String nombre, String email, String password, String especialidad, int experiencia, String certificaciones) {
        this.identificacion = identificador;
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

    @Override
    public String toString() {
        return "Entrenador{" +
                "identificacion=" + identificacion +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}

