package com.example.api;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import com.example.bl.WhatsAppService;
import com.example.dto.MessageRequest;

import jakarta.inject.Inject;

@Path("/api/whatsapp/message")
public class WhatsAppAPI {

    @Inject
    WhatsAppService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String sendMessage(MessageRequest request) {
        return service.sendMessage(request.to, request.body);
    }
}
