package com.example.bl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import com.example.service.WhatsAppClient;
@ApplicationScoped
public class WhatsAppService {

    @Inject
    @RestClient
    WhatsAppClient whatsAppClient;
    
    public void sendWhatsAppMessage(String phoneNumber, String date, String time) {
        Map<String, Object> message = new HashMap<>();
        message.put("messaging_product", "whatsapp");
        message.put("to", phoneNumber);
        message.put("type", "template");

        Map<String, Object> template = new HashMap<>();
        template.put("name", "notification"); // Nombre de la plantilla
        template.put("language", Map.of("code", "es_MX"));

        Map<String, Object> body = new HashMap<>();
        body.put("type", "body");
        body.put("parameters", new Object[]{
            Map.of("type", "text", "text", date),
            Map.of("type", "text", "text", time)
        });

        template.put("components", new Object[]{body});
        message.put("template", template);

        // Enviar mensaje a la API de WhatsApp
        whatsAppClient.sendMessage(message);
    }
}