package org.example.service;


import org.example.model.Entrenamiento;
import org.example.repository.EntrenamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EntrenamientoService {

    private EntrenamientoRepository entrenamientoRepository;

    @Autowired
    public EntrenamientoService(EntrenamientoRepository entrenamientoRepository) {
        this.entrenamientoRepository = entrenamientoRepository;
    }

    public String registrarEntrenamiento(Entrenamiento entrenamiento) {
        entrenamientoRepository.save(entrenamiento);
        return "se registro el entrenamiento";
    }

    public List<Entrenamiento> obtenerEntrenamientosPorAprendiz(int aprendizId) {
        List<Entrenamiento> listaEntrenamientos = entrenamientoRepository.findByAprendizId(aprendizId);
        imprimiEntrenamientos(listaEntrenamientos);
        return listaEntrenamientos;
    }
    public String generarReporteMensual(int aprendizId, int mes,  int anno) {
        List<Entrenamiento> entrenamientos = obtenerEntrenamientosPorAprendiz(aprendizId);

        // Filtrar los entrenamientos que corresponden al mes y año especificados
        Calendar calendar = Calendar.getInstance();
        entrenamientos = entrenamientos.stream()
                .filter(entrenamiento -> {
                    calendar.setTime(entrenamiento.getFecha());
                    return calendar.get(Calendar.MONTH) == mes - 1 && calendar.get(Calendar.YEAR) == anno;
                })
                .collect(Collectors.toList());

        if (entrenamientos.isEmpty()) {
            return "No se encontraron entrenamientos para el mes y año especificados.";
        }

        entrenamientos.sort(Comparator.comparing(Entrenamiento::getFecha));

        Map<Integer, List<Entrenamiento>> entrenamientosPorSemana = new LinkedHashMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Entrenamiento entrenamiento : entrenamientos) {
            calendar.setTime(entrenamiento.getFecha());
            int semana = calendar.get(Calendar.WEEK_OF_MONTH);
            entrenamientosPorSemana.computeIfAbsent(semana, k -> new ArrayList<>()).add(entrenamiento);
        }

        StringBuilder reporte = new StringBuilder();
        reporte.append("Reporte Mensual del Aprendiz ").append(aprendizId).append(" (")
                .append(getNombreMes(mes)).append(" ").append(anno).append("):\n");
        for (Map.Entry<Integer, List<Entrenamiento>> entry : entrenamientosPorSemana.entrySet()) {
            int semana = entry.getKey();
            reporte.append("Semana ").append(semana).append(":\n");
            for (Entrenamiento entrenamiento : entry.getValue()) {
                reporte.append("- ").append(getNombreDia(entrenamiento.getFecha())).append(": ")
                        .append(dateFormat.format(entrenamiento.getFecha())).append(", ")
                        .append(entrenamiento.getCategoria()).append("\n");
            }
        }

        return reporte.toString();
    }

    private String getNombreMes(int mes) {
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        return meses[mes - 1];
    }

    private String getNombreDia(Date fecha) {
        String[] dias = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
        return dias[diaSemana - 1];
    }
    public void imprimiEntrenamientos(List<Entrenamiento> listaEntrenamientos) {
        for (Entrenamiento entrenamiento : listaEntrenamientos) {
            System.out.println("ID: " + entrenamiento.getId());
            System.out.println("Categoría: " + entrenamiento.getCategoria());
            System.out.println("Fecha: " + entrenamiento.getFecha());
            System.out.println("ID del Aprendiz: " + entrenamiento.getAprendiz_id());
            System.out.println("Nombre del Aprendiz: " + entrenamiento.getNombreAprendiz());
            System.out.println("Tiempo de Entrenamiento: " + entrenamiento.getTiempoEntrenamiento());
            System.out.println("Nombre del Entrenador: " + entrenamiento.getNombreEntrenador());
            System.out.println("-------------------------------------");
        }
    }
}