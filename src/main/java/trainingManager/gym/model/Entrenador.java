package trainingManager.gym.model;

public class Entrenador {
    private String identificador;//Identificador único del entrenador.
    private String nombre; // Nombre completo del entrenador.
    private String Correo;// Dirección de correo electrónico del entrenador para comunicación.
    private String password;// Contraseña para acceder al perfil del entrenador.
    private String especialidad ;// Área de especialización del entrenador (por ejemplo, entrenamiento de fuerza,entrenamiento cardiovascular, etc.).
    private String experiencia; // Experiencia en años como entrenador.
    private String certificaciones; // Certificaciones relevantes obtenidas por el entrenador.

    public Entrenador(String identificador, String nombre, String correo, String password, String especialidad, String experiencia, String certificaciones) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.Correo = correo;
        this.password = password;
        this.especialidad = especialidad;
        this.experiencia = experiencia;
        this.certificaciones = certificaciones;
    }
}
