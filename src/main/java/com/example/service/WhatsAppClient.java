package com.example.service;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.example.config.WhatsAppAuthFilter;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;

import java.util.Map;

@RegisterRestClient(baseUri = "https://graph.facebook.com/v22.0/564075936794992/messages")
@RegisterProvider(WhatsAppAuthFilter.class)
public interface WhatsAppClient {


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    // @ClientHeaderParam(name = "Authorization", value = "Bearer EAAJhNx9BSi8BO2oVtmhZCQdVWwbSA0X27U0fZAS3C7dqSHJjTMaR2ZCl5luPKZBvwxVnZC8N4y762oWeOBPsr437YskbbNtyUmawzqrhLzNt9QL2ZAcZAEDtlLnKLyGBmVrjiCJPd3dJp4ZAsMeoP5LiHxh18toZC7WU3ZBOZBFtLBLRt7ZBMh2GcuTpmBOljPrVBFgyTOOuk1saFMJS4r8wwtnVuetvpMsZD")
    @ClientHeaderParam(name = "Content-Type", value = "application/json")
    void sendMessage(Map<String, Object> messageBody);
}
