package com.stylo.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Aplica CORS a todos los endpoints
                .allowedOrigins("https://frontendstylo-production.up.railway.app")  // Permitir solicitudes solo desde Railway frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Permitir estos métodos HTTP
                .allowedHeaders("*")  // Permitir todos los headers
                .allowCredentials(true);  // Permitir el uso de credenciales (cookies, autenticación, etc.)
    }
}
