package com.example.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class MessageRequest {
    public String to;
    public String body;

    public MessageRequest() {
    }

    public MessageRequest(String to, String body) {
        this.to = to;
        this.body = body;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
