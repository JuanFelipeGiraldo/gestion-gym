package org.example.dto;

public class EntrenadorAsociadoDTO {

    private int identificadorEntrenador;
    private String nombreEntrenador;

    public EntrenadorAsociadoDTO(int idEntrenador, String nombreEntrenador) {
        this.identificadorEntrenador = idEntrenador;
        this.nombreEntrenador = nombreEntrenador;
    }

    public int getIdentificadorEntrenador() {
        return identificadorEntrenador;
    }

    public void setIdentificadorEntrenador(int identificadorEntrenador) {
        this.identificadorEntrenador = identificadorEntrenador;
    }

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    public void setNombreEntrenador(String nombreEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
    }
}
