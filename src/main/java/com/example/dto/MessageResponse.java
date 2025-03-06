package com.example.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class MessageResponse {
    public String sid;
    public String status;
    public String dateCreated;
    public String to;
    public String from;
    public String body;

    public MessageResponse() {
    }
    
    public MessageResponse(String sid, String status, String dateCreated, String to, String from, String body) {
        this.sid = sid;
        this.status = status;
        this.dateCreated = dateCreated;
        this.to = to;
        this.from = from;
        this.body = body;
    }
}
