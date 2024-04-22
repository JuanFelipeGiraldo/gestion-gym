package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReportesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReportesApplication.class, args);
        System.out.println("\nHello...World from REPORTES-SERVICIO");
    }
}
