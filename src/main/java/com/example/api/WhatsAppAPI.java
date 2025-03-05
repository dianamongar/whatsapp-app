package com.example.api;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import com.example.bl.WhatsAppService;
import com.example.dto.MessageRequest;
import com.example.dto.MessageResponse;
import com.example.dto.MessageTemplateRequest;

import jakarta.inject.Inject;

@Path("/api/whatsapp/message")
public class WhatsAppAPI {

    @Inject
    WhatsAppService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MessageResponse sendMessage(MessageRequest request) {
        return service.sendMessage(request.to, request.body);
    }

    @POST
    @Path("/template")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MessageResponse sendConfirmTemplateMessage(MessageTemplateRequest request) {
        return service.sendConfirmTemplateMessage(request.getTo(), request.getBody(), request.getDate(), request.getTime());
    }
}
