package com.example.api;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

import com.example.bl.WhatsAppService;

import jakarta.inject.Inject;

@Path("/api/whatsapp/message")
public class WhatsAppAPI {

    @Inject
    WhatsAppService whatsAppService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendMessage(Map<String, Object> messageBody){
        String phoneNumber = messageBody.get("to").toString();
        String date = messageBody.get("date").toString();
        String time = messageBody.get("time").toString();

        if (phoneNumber == null || date == null || time == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("error", "Faltan parámetros requeridos"))
                    .build();
        }

        whatsAppService.sendWhatsAppMessage(phoneNumber, date, time);
        return Response.ok(Map.of("message", "Mensaje enviado con éxito")).build();
    }
}
