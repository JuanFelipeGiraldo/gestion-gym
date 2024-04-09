package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "entrenadores")
public class Entrenador {
    @Id
    @Column(name = "identificacion")
    private Integer identificacion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "especialidad")
    private String especialidad;

    @Column(name = "anios_experiencia")
    private int aniosExperiencia;

    @Column(name = "certificaciones")
    private String certificaciones;

    @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL)
    private List<Aprendiz> aprendices;

    public Entrenador() {
    }

    public Entrenador(int identificador, String nombre, String email, String password, String especialidad, int aniosExperiencia, String certificaciones) {
        this.identificacion = identificador;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
        this.certificaciones = certificaciones;
    }
}

