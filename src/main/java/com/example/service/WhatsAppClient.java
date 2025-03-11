package com.example.service;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;

import java.util.Map;

@RegisterRestClient(baseUri = "https://graph.facebook.com/v22.0/564075936794992/messages")
@ClientHeaderParam(name = "Authorization", value = "Bearer EAAJlebb0VCoBOzL6cOxMxZBoHkTxwTa3Y448TcEZBC6lWvZBDzZADfHZBRGpfzJMeEmxd3h4awq93pcAUug6AHEgCXG4TMeuEuDm0MyydplxI5lCU8ZBfAv9hLbGQ8fG4GcIG2MHQ34G4iZBgM8cIVRKKimOw0k581G0dffdJSGppZBVXrjdR5XStpDDO6ydMVgBp9aqzUMss2RLi2QLaLp7WVj7XJgZD")
@ClientHeaderParam(name = "Content-Type", value = "application/json")
public interface WhatsAppClient {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void sendMessage(Map<String, Object> messageBody);
}
