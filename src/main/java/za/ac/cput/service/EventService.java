package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.eventdomains.Event;
import za.ac.cput.domain.eventdomains.EventDTO;
import za.ac.cput.repository.EventRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepo eventRepo;

    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    private EventDTO toDTO(Event event) {
        return new EventDTO(
                event.getEventId(),
                event.getEventName(),
                event.getEventDescription(),
                event.getEventLocation(),
                event.getEventDate(),
                event.getEventTime(),
                event.getCategory(),
                event.getStatus()
        );
    }

    // Convert DTO → Entity
    private Event toEntity(EventDTO dto) {
        Event.Builder builder = new Event.Builder();

        if (dto.getEventId() != null) {
            builder.setEventId(dto.getEventId().intValue());
        }

        builder.setEventName(dto.getEventName())
                .setEventDescription(dto.getEventDescription())
                .setEventLocation(dto.getEventLocation())
                .setEventDate(dto.getEventDate())
                .setEventTime(dto.getEventTime())
                .setCategory(dto.getCategory())
                .setStatus(dto.getStatus());

        return builder.build();
    }

    public EventDTO createEvent(EventDTO dto) {
        Event event = toEntity(dto);
        event = eventRepo.save(event);
        return toDTO(event);
    }

    public EventDTO readEvent(Long id) {
        Optional<Event> optionalEvent = eventRepo.findById(id);
        if (optionalEvent.isPresent()) {
            return toDTO(optionalEvent.get());
        }
        return null;
    }

    public EventDTO updateEvent(Long id, EventDTO dto) {
        Optional<Event> optionalEvent = eventRepo.findById(id);
        if (optionalEvent.isPresent()) {
            Event existing = optionalEvent.get();

            // Update only provided fields
            if (dto.getEventName() != null)
                existing = new Event.Builder().copy(existing).setEventName(dto.getEventName()).build();
            if (dto.getEventDescription() != null)
                existing = new Event.Builder().copy(existing).setEventDescription(dto.getEventDescription()).build();
            if (dto.getEventLocation() != null)
                existing = new Event.Builder().copy(existing).setEventLocation(dto.getEventLocation()).build();
            if (dto.getEventDate() != null)
                existing = new Event.Builder().copy(existing).setEventDate(dto.getEventDate()).build();
            if (dto.getEventTime() != null)
                existing = new Event.Builder().copy(existing).setEventTime(dto.getEventTime()).build();
            if (dto.getCategory() != null)
                existing = new Event.Builder().copy(existing).setCategory(dto.getCategory()).build();
            if (dto.getStatus() != null)
                existing = new Event.Builder().copy(existing).setStatus(dto.getStatus()).build();

            Event updated = eventRepo.save(existing);
            return toDTO(updated);
        }
        return null;
    }

    public boolean deleteEvent(Long id) {
        if (eventRepo.existsById(id)) {
            eventRepo.deleteById(id);
            return true;
        }
        return false;
    }

}
