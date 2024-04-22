package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GymApplication {
    public static void main(String [] args) {
        SpringApplication.run(GymApplication.class, args);
        System.out.println("\n--> GYM-SERVCICE en ejecución");
    }
}
