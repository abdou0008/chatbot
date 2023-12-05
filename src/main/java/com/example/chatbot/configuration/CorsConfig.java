package com.example.chatbot.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // URL à laquelle appliquer la configuration CORS
                .allowedOriginPatterns("http://localhost:4200") // Autoriser l'origine spécifique du frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Méthodes HTTP autorisées
                .allowedHeaders("Origin", "Content-Type", "Accept") // En-têtes autorisés
                .allowCredentials(true); // Autoriser l'envoi des cookies
    }
}

