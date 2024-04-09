package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors
                                .withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
//                .apiInfo(apiInfo());
    }

    // Creación del encabezado
    /*private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("API Restful Para la Gestión de un Gimnasio")
                .description("Esta api permite gestionar el registro de usuarios y generación de informes...")
                .version("1.0.0")
                *//*.contact(new Contact("Felipe Giraldo","","correo@gmail.com"))
                .contact(new Contact("Miguel Martin","","correo@gmail.com"))*//*
                .build();
    }*/
}
