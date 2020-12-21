package com.epam.jgmp.event.service.controller;

import com.epam.jgmp.event.service.dto.Event;
import com.epam.jgmp.event.service.impl.EventService;
import com.epam.jgmp.event.service.dto.EventDTO;
import com.epam.jgmp.event.service.dto.EventRequestFailure;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/l0/v1.0/event-service")
@Api(value = "event-service")
public class EventServiceControllerL0 {

  private final EventService eventService;

  public EventServiceControllerL0(EventService eventService) {
    this.eventService = eventService;
  }

  @PostMapping(produces = "application/json")
  @ApiOperation(response = ResponseEntity.class, value = "Create new Event")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Created Event Details", response = Event.class),
        @ApiResponse(
            code = 200,
            message = "Internal Server Error",
            response = EventRequestFailure.class)
      })
  public ResponseEntity<?> createEvent(@RequestBody EventDTO eventDTO) {

    Event event = new Event();
    event.setTitle(eventDTO.getTitle());
    event.setSpeaker(eventDTO.getSpeaker());
    event.setPlace(eventDTO.getPlace());
    event.setEventType(eventDTO.getEventType());
    event.setDateTime(eventDTO.getDateTime());

    Event createdEvent = eventService.createEvent(event);
    ResponseEntity responseEntity;

    if (createdEvent != null) {
      responseEntity = ResponseEntity.ok(createdEvent);
    } else {
      responseEntity = ResponseEntity.ok(new EventRequestFailure("Internal Server Error"));
    }

    return responseEntity;
  }
}
