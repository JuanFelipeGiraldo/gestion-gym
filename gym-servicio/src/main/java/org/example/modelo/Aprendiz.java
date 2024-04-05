package org.example.modelo;

public class Aprendiz {

    private int identificacion;
    private String nombre;
    private String email;
    private String password;
    private String fecha_nacimiento;
    private String genero;
    private String objetivo_entrenamiento;
    private String nivel_condicion_fisica;
    private int entrenador_id;

    public Aprendiz(int identificacion, String nombre, String email, String password, String fecha_nacimiento, String genero, String objetivo_entrenamiento, String nivel_condicion_fisica, int entrenador_id) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.fecha_nacimiento = fecha_nacimiento;
        this.genero = genero;
        this.objetivo_entrenamiento = objetivo_entrenamiento;
        this.nivel_condicion_fisica = nivel_condicion_fisica;
        this.entrenador_id = entrenador_id;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getObjetivo_entrenamiento() {
        return objetivo_entrenamiento;
    }

    public void setObjetivo_entrenamiento(String objetivo_entrenamiento) {
        this.objetivo_entrenamiento = objetivo_entrenamiento;
    }

    public String getNivel_condicion_fisica() {
        return nivel_condicion_fisica;
    }

    public void setNivel_condicion_fisica(String nivel_condicion_fisica) {
        this.nivel_condicion_fisica = nivel_condicion_fisica;
    }

    public int getEntrenador_id() {
        return entrenador_id;
    }

    public void setEntrenador_id(int entrenador_id) {
        this.entrenador_id = entrenador_id;
    }
}
