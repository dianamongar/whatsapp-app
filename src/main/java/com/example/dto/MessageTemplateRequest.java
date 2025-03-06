package com.example.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class MessageTemplateRequest {
    private String to;
    private String body;
    private String date;
    private String time;

    public MessageTemplateRequest() {
    }

    public MessageTemplateRequest(String to, String body, String date, String time) {
        this.to = to;
        this.body = body;
        this.date = date;
        this.time = time;
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

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
