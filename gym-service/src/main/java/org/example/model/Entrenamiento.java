package org.example.model;

import java.util.Date;
import java.util.UUID;
import io.swagger.v3.oas.annotations.Hidden;

public class Entrenamiento {
    private int aprendiz_id;
    @Hidden
    private String nombreAprendiz;
    private String categoria;
    private Date fecha;
    @Hidden
    private  String id;
    private int tiempoEntrenamiento;
    @Hidden
    private String nombreEntrenador;



    public Entrenamiento(int aprendiz_id, String categoria, Date fecha, int tiempoEntrenamiento) {
        this.aprendiz_id = aprendiz_id;
        this.nombreAprendiz = nombreAprendiz;
        this.categoria = categoria;
        this.fecha = fecha;
        this.tiempoEntrenamiento = tiempoEntrenamiento;
        this.nombreEntrenador = nombreEntrenador;
        this.id = UUID.randomUUID().toString();
    }

    public int getAprendiz_id() {
        return aprendiz_id;
    }

    public void setAprendiz_id(int aprendiz_id) {
        this.aprendiz_id = aprendiz_id;
    }

    public String getNombreAprendiz() {
        return nombreAprendiz;
    }

    public void setNombreAprendiz(String nombreAprendiz) {
        this.nombreAprendiz = nombreAprendiz;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTiempoEntrenamiento() {
        return tiempoEntrenamiento;
    }

    public void setTiempoEntrenamiento(int tiempoEntrenamiento) {
        this.tiempoEntrenamiento = tiempoEntrenamiento;
    }

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    public void setNombreEntrenador(String nombreEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
    }
}
