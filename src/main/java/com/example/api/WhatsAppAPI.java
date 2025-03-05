package com.example.api;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import com.example.bl.WhatsAppService;
import com.example.dto.MessageRequest;
import com.example.dto.MessageResponse;
import com.example.dto.MessageTemplateRequest;
import com.twilio.rest.api.v2010.account.Message;

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

    @GET
    @Path("/{sid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchMessage(@PathParam("sid") String sid) {
        try {
            Message message = service.fetchMessage(sid);
            return Response.status(Response.Status.OK).entity(message).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}
