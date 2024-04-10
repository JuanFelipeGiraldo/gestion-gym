package org.example.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API Restful Para la Gestión de un Gimnasio",
                version = "1.0.0",
                description = "Esta api permite gestionar el registro de usuarios y generación de informes..."
        )
)
public class SwaggerConfig {
}
