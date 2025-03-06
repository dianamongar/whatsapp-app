package com.example.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection(targets = {com.twilio.rest.api.v2010.account.Message.class})
public class MessageReflectionConfiguration {
}
