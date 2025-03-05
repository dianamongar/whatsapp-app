package com.example.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "https://api.twilio.com/2010-04-01/Accounts/{AccountSid}/Messages.json")
public interface WhatsAppClient {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    String sendMessage(@FormParam("To") String to, 
                       @FormParam("From") String from, 
                       @FormParam("Body") String body);
}
