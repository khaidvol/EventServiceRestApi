package com.epam.jgmp.event.service.dto;

import java.time.LocalDateTime;

public class EventDTO {

    private String title;

    private String place;

    private String speaker;

    private EventType eventType;

    private LocalDateTime dateTime;

    public EventDTO() {
    }

    public EventDTO(String title, String place, String speaker, EventType eventType, LocalDateTime dateTime) {
        this.title = title;
        this.place = place;
        this.speaker = speaker;
        this.eventType = eventType;
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

}
