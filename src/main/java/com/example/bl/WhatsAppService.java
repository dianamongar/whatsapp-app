package com.example.bl;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.json.JSONObject;

import com.example.dto.MessageResponse;
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

    @ConfigProperty(name = "twilio.whatsapp.template")
    String confirmTemplate;


    public MessageResponse sendMessage(String to, String messageBody) {
        Twilio.init(accountSid, authToken);
        Message message = Message.creator(
                new PhoneNumber("whatsapp:" + to),  // Número de destino
                new PhoneNumber(fromNumber),        // Número de Twilio
                messageBody                         // Contenido del mensaje
        ).create();

        return new MessageResponse(
                message.getSid(),
                message.getStatus().toString(),
                message.getDateCreated().toString(),
                message.getTo(),
                message.getFrom().toString(),
                message.getBody()
        );
    }
    
    public MessageResponse sendConfirmTemplateMessage(String to, String messageBody, String date, String time) {
        Twilio.init(accountSid, authToken);
        HashMap<String, Object> params = new HashMap<>();
        params.put("1", date);  // Parámetro para la fecha
        params.put("2", time);   // Parámetro para la hora

        String contentVariables = new JSONObject(params).toString();

        Message message = Message.creator(
                new PhoneNumber("whatsapp:" + to),  // Número de destino
                new PhoneNumber(fromNumber),  // Número de Twilio
                confirmTemplate // ID de la plantilla de WhatsApp
        )
        .setContentSid(confirmTemplate)
        .setContentVariables(contentVariables)  // Parámetros de la plantilla
        .create(); 

        return new MessageResponse(
                message.getSid(),
                message.getStatus().toString(),
                message.getDateCreated().toString(),
                message.getTo(),
                message.getFrom().toString(),
                message.getBody()
        );
    }
    
    public Message fetchMessage(String messageSid) {
        Twilio.init(accountSid, authToken);
        return Message.fetcher(messageSid).fetch();
    }
}