package com.example.gestortareas.web.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
//informacion general de la api
@OpenAPIDefinition(
        info = @Info(
                title = "Gestor Tareas",
                version = "1.0.0",
                description = "Esto es una pi para gestionar tareas"
        )
)
public class SwaggerConfig {


}
