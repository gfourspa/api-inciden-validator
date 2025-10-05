package com.gfour.api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

/**
 * Configuración de OpenAPI/Swagger para documentación automática de la API
 */
@Configuration
public class OpenApiConfig {

    @Value("${server.port:8080}")
    private String serverPort;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Incident Validator API")
                        .description("API REST para validación de incidencias eléctricas. " +
                                "Esta API proporciona datos de interrupciones y conectividad del sistema eléctrico.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("GFour SPA")
                                .email("soporte@gfourspa.cl")
                                .url("https://www.gfourspa.cl"))
                        .license(new License()
                                .name("Proprietary")
                                .url("https://www.gfourspa.cl/license")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:" + serverPort)
                                .description("Servidor de desarrollo"),
                        new Server()
                                .url("https://api.gfourspa.cl")
                                .description("Servidor de producción")
                ));
    }
}