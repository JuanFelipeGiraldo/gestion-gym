package org.example.model;

import java.util.Date;

public class Entrenamiento {

    private int id;
    private String categoria;
    private Date fecha;
    private int aprendiz_id;

    public Entrenamiento(int id, String categoria, Date fecha, int aprendiz_id) {
        this.id = id;
        this.categoria = categoria;
        this.fecha = fecha;
        this.aprendiz_id = aprendiz_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
