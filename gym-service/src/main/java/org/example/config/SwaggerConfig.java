package org.example.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI openAPIConfig(){
                return new OpenAPI()
                        .addSecurityItem(new SecurityRequirement().
                                addList("Bearer Authentication"))
                        .components(new Components().addSecuritySchemes
                                ("Bearer Authentication", createAPIKeyScheme()))
                        .info(new Info()
                                .title("API RESTful para Gestión de un Gimnasio")
                                .description("La aplicación facilita el registro de entrenadores y aprendices, además de " +
                                        "administrar las actividades de entrenamiento de cada aprendiz, permitiendo " +
                                                "generar reportes detallados de sus entrenamientos.")
                                .version("🔩 1.0")
                        );
        }

        private SecurityScheme createAPIKeyScheme() {
                return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                        .bearerFormat("JWT")
                        .scheme("bearer");
        }
}
