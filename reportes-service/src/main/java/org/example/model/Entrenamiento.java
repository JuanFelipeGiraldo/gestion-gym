package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "registro")
public class Entrenamiento {

    @Id
    private String id;
    private String categoria;
    private Date fecha;
    private int aprendiz_id;
    private String nombreAprendiz;
    private int tiempoEntrenamiento;
    private String nombreEntrenador;

    public Entrenamiento(String id, String categoria, Date fecha, int aprendiz_id, String nombreAprendiz, int tiempoEntrenamiento, String nombreEntrenador) {
        this.id = id;
        this.categoria = categoria;
        this.fecha = fecha;
        this.aprendiz_id = aprendiz_id;
        this.nombreAprendiz = nombreAprendiz;
        this.tiempoEntrenamiento = tiempoEntrenamiento;
        this.nombreEntrenador = nombreEntrenador;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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