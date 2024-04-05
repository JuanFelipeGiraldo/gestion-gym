package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GymApplication {
    public static void main(String[] args) {
        SpringApplication.run(GymApplication.class, args);
        System.out.println("\nHello...World from GYM-SERVICIO");
    }
}
