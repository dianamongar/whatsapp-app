package com.example.bl;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@ApplicationScoped
public class WhatsAppService {

    @ConfigProperty(name = "twilio.account.sid")
    String accountSid;

    @ConfigProperty(name = "twilio.auth.token")
    String authToken;

    @ConfigProperty(name = "twilio.whatsapp.from")
    String fromNumber;

    public String sendMessage(String to, String messageBody) {
        // Inicializar Twilio con las credenciales
        Twilio.init(accountSid, authToken);

        // Enviar mensaje de WhatsApp
        Message message = Message.creator(
                new PhoneNumber("whatsapp:" + to),  // Número de destino
                new PhoneNumber(fromNumber),        // Número de Twilio
                messageBody                         // Contenido del mensaje
        ).create();

        return message.getSid(); // Retorna el ID del mensaje enviado
    }
}