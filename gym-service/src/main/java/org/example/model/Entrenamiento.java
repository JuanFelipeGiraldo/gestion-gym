package org.example.model;

import java.util.Date;
import java.util.UUID;
import io.swagger.v3.oas.annotations.Hidden;

public class Entrenamiento {
    private int aprendiz_id;
    @Hidden
    private  String id;
    private String categoria;
    private Date fecha;


    public Entrenamiento( String categoria, Date fecha, int aprendiz_id) {
        this.id = UUID.randomUUID().toString();;
        this.categoria = categoria;
        this.fecha = fecha;
        this.aprendiz_id = aprendiz_id;
    }

    public int getAprendiz_id() {
        return aprendiz_id;
    }

    public void setAprendiz_id(int aprendiz_id) {
        this.aprendiz_id = aprendiz_id;
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
}
