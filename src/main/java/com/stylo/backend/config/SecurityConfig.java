package com.stylo.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Deshabilita la protección CSRF para facilitar las pruebas
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()  // Permitir el acceso a todos los endpoints sin autenticación
            );
        return http.build();
    }
}
