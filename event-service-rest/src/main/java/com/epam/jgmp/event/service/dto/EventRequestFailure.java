package com.epam.jgmp.event.service.dto;

public class EventRequestFailure {

    String message;

    public EventRequestFailure(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
