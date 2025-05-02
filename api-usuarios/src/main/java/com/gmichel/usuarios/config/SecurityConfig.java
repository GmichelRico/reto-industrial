package com.gmichel.usuarios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
* Clase de configuracion de seguridad para el backend
* define reglas de acceso y habilita CORS para el entorno
* */
@Configuration
public class SecurityConfig {

    /*
    * Define un filtro principal de seguridad para el HTTP en todas las peticiones
    * deshabilitamos el certificado ssl https
    * habilita el CORS (para recibir los metodos del CRUD)
    * permite todas las rutas sin autenticacion
    * */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(Customizer.withDefaults()) // Usa la config de abajo
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Permite todas las rutas
                );
        return http.build();
    }
    /*
    * Configura el CORS permitiendo solicitudes desde el front
    * esta configuracion se aplica de manera global para todos los endpoint
    * */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
