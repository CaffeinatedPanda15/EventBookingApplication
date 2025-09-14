package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.eventdomains.Event;
import za.ac.cput.repository.EventRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EventService implements iService<Event, Long> {

    private final EventRepo eventRepo;

    @Autowired
    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public Event create(Event event) {
        // Save the event to the DB
        return eventRepo.save(event);
    }

    @Override
    public Event read(Long id) {
        // Find by ID, return null if not found
        Optional<Event> optionalEvent = eventRepo.findById(id);
        return optionalEvent.orElse(null);
    }

    @Override
    public Event update(Event event) {
        if (event.getEventId() == 0 || !eventRepo.existsById(event.getEventId())) {
            return null; // Cannot update non-existing event
        }
        return eventRepo.save(event); // Save overwrites existing entity
    }

    @Override
    public void delete(Long id) {
        if (eventRepo.existsById(id)) {
            eventRepo.deleteById(id);
        }
    }

    @Override
    public List<Event> getAll() {
        return eventRepo.findAll();
    }
}
