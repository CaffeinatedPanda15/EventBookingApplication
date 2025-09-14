package za.ac.cput.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.eventdomains.Event;
import za.ac.cput.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event eventData) {
        Event created = eventService.create(eventData);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable long id, @RequestBody Event eventData) {
        Event existing = eventService.read(id);
        if (existing == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Event updated = new Event.Builder()
                .copy(existing)
                .setEventName(eventData.getEventName())
                .setEventDescription(eventData.getEventDescription())
                .setEventLocation(eventData.getEventLocation())
                .setEventDate(eventData.getEventDate())
                .setEventTime(eventData.getEventTime())
                .setCategory(eventData.getCategory())
                .setStatus(eventData.getStatus())
                .build();

        return new ResponseEntity<>(eventService.update(updated), HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable long id) {
        Event existing = eventService.read(id);
        if (existing == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        eventService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

