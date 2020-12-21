package com.epam.jgmp.event.service.controller;

import com.epam.jgmp.event.service.dto.Event;
import com.epam.jgmp.event.service.impl.EventService;
import com.epam.jgmp.event.service.dto.EventDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/l2/v1.0/event-service/events")
@Api(value = "event-service")
public class EventServiceControllerL2 {

  private final EventService eventService;

  public EventServiceControllerL2(EventService eventService) {
    this.eventService = eventService;
  }

  @GetMapping(produces = "application/json")
  @ApiOperation(response = List.class, value = "Returns list of all Event")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Events Details", response = List.class),
        @ApiResponse(code = 204, message = "Events not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
      })
  public @ResponseBody ResponseEntity<?> getAllEvents() {

    List<Event> events = eventService.getAllEvents();
    ResponseEntity responseEntity;

    if (events != null && !events.isEmpty()) {
      responseEntity = ResponseEntity.ok(events);
    } else {
      responseEntity = ResponseEntity.noContent().build();
    }
    return responseEntity;
  }

  @GetMapping(path = "title/{title}", produces = "application/json")
  @ApiOperation(response = List.class, value = "Returns list of all Event by title")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Events Details", response = List.class),
        @ApiResponse(code = 204, message = "Events not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
      })
  public @ResponseBody ResponseEntity<?> getAllEventsByTitle(
      @PathVariable(name = "title") String title) {

    List<Event> events = eventService.getAllEventsByTitle(title);
    ResponseEntity responseEntity;

    if (events != null && !events.isEmpty()) {
      responseEntity = ResponseEntity.ok(events);
    } else {
      responseEntity = ResponseEntity.noContent().build();
    }

    return responseEntity;
  }

  @GetMapping(path = "/{id}", produces = "application/json")
  @ApiOperation(response = Event.class, value = "Returns event by its id")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Event Details", response = Event.class),
        @ApiResponse(code = 404, message = "Event not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
      })
  public ResponseEntity<?> getEvent(@PathVariable(name = "id") Long id) {

    Event event = eventService.getEvent(id);
    ResponseEntity responseEntity;

    if (event != null) {
      responseEntity = ResponseEntity.ok(event);
    } else {
      responseEntity = ResponseEntity.notFound().build();
    }

    return responseEntity;
  }

  @PostMapping(produces = "application/json")
  @ApiOperation(response = Event.class, value = "Create new Event")
  @ApiResponses(
      value = {
        @ApiResponse(code = 201, message = "Event created", response = Event.class),
        @ApiResponse(code = 404, message = "Event not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
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
      responseEntity = ResponseEntity.notFound().build();
    }

    return responseEntity;
  }

  @PostMapping(path = "/{id}", produces = "application/json")
  @ApiOperation(response = Event.class, value = "Update Event")
  @ApiResponses(
      value = {
        @ApiResponse(code = 201, message = "Event updated", response = Event.class),
        @ApiResponse(code = 404, message = "Event not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
      })
  public ResponseEntity<?> updateEvent(
      @PathVariable("id") Long id, @RequestBody EventDTO eventDTO) {

    Event event = new Event();
    event.setTitle(eventDTO.getTitle());
    event.setSpeaker(eventDTO.getSpeaker());
    event.setPlace(eventDTO.getPlace());
    event.setEventType(eventDTO.getEventType());
    event.setDateTime(eventDTO.getDateTime());

    Event updatedEvent = eventService.updateEvent(id, event);

    ResponseEntity responseEntity;

    if (updatedEvent != null) {
      responseEntity = ResponseEntity.ok(updatedEvent);
    } else {
      responseEntity = ResponseEntity.notFound().build();
    }

    return responseEntity;
  }

  @DeleteMapping(path = "/{id}", produces = "application/json")
  @ApiOperation(response = Event.class, value = "Deletes event by its id")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Event Deleted", response = Event.class),
        @ApiResponse(code = 404, message = "Event not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
      })
  public ResponseEntity<?> deleteEvent(@PathVariable(name = "id") Long id) {

    Event event = eventService.deleteEvent(id);
    ResponseEntity responseEntity;

    if (event != null) {
      responseEntity = ResponseEntity.ok(event);
    } else {
      responseEntity = ResponseEntity.notFound().build();
    }

    return responseEntity;
  }
}
