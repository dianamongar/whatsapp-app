package com.example.config;

import jakarta.inject.Inject;
import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.core.HttpHeaders;
import org.eclipse.microprofile.config.inject.ConfigProperty;

public class WhatsAppAuthFilter implements ClientRequestFilter {

    @Inject
    @ConfigProperty(name = "whatsapp.token") // Inyecta el token desde application.properties
    String whatsappToken;

    @Override
    public void filter(ClientRequestContext requestContext) {
        // Agrega el encabezado de autorización con el token
        requestContext.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + whatsappToken);
    }
}