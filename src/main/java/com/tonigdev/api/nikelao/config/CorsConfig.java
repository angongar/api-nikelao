package com.tonigdev.api.nikelao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api-nikelao/**") // Especifica el mapeo para el que se habilitará CORS
                .allowedOrigins("http://localhost:8007") // Permite solicitudes desde este origen
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite estos métodos HTTP
                .allowedHeaders("*"); // Permite todos los encabezados
    }
}
