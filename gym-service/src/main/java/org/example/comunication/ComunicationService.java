package org.example.comunication;

import org.example.model.Entrenamiento;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="reportes-service", url ="localhost:8095" )
public interface ComunicationService {

    @PostMapping("/entrenamiento")
    public String registrarEntrenamiento(@RequestBody Entrenamiento entrenamiento);

}
