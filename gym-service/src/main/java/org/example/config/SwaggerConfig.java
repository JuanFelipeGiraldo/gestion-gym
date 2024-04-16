package org.example.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI openAPIConfig(){
                return new OpenAPI()
                        .components(new Components())
                        .info(new Info()
                                .title("API Restful Para la Gestión de un Gimnasio")
                                .description("Esta api permite gestionar el registro de usuarios y generación de informes...")
                                .version("1.0"));
        }
}
