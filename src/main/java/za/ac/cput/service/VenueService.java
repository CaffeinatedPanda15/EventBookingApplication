package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.eventdomains.Event;
import za.ac.cput.domain.eventdomains.EventDTO;
import za.ac.cput.domain.eventdomains.Venue;
import za.ac.cput.domain.eventdomains.VenueDTO;
import za.ac.cput.repository.eventrepositories.IVenueRepository;

import java.util.List;
import java.util.Optional;


@Service
public class VenueService{

    private final IVenueRepository venueRepository;

    public VenueService(IVenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    private VenueDTO toDTO(Venue venue) {
        return new VenueDTO(
                venue.getVenueId(),
                venue.getVenueName(),
                venue.getVenueAddress(),
                venue.getVenueDescription(),
                venue.getVenueCapacity(),
                venue.getVenuePrice(),
                venue.getVenueImage()
        );
    }

    private Venue toEntity(VenueDTO dto) {
        Venue.Builder builder = new Venue.Builder();

        if (dto.getVenueId() != 0) {
            builder.setVenueId(dto.getVenueId());
        }

        builder.setVenueName(dto.getVenueName())
                .setVenueDescription(dto.getVenueDescription())
                .setVenueCapacity(dto.getVenueCapacity())
                .setVenuePrice(dto.getVenuePrice());

        return builder.build();
    }



    public VenueDTO createEvent(VenueDTO dto) {
        Venue event = toEntity(dto);
        event = venueRepository.save(event);
        return toDTO(event);
    }

    public VenueDTO readVenue(int id) {
        Optional<Venue> optionalVenue = venueRepository.findById(id);
        if (optionalVenue.isPresent()) {
            return toDTO(optionalVenue.get());
        }
        return null;
    }

    public VenueDTO updateEvent(int id, VenueDTO dto) {
        Optional<Venue> optionalEvent = venueRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Venue existing = optionalEvent.get();

            // Update only provided fields
            if (dto.getVenueName() != null)
                existing = new Venue.Builder().copy(existing).setVenueName(dto.getVenueName()).build();
            if (dto.getVenueDescription() != null)
                existing = new Venue.Builder().copy(existing).setVenueDescription(dto.getVenueDescription()).build();
            if (dto.getVenueCapacity() != 0)
                existing = new Venue.Builder().copy(existing).setVenueCapacity(dto.getVenueCapacity()).build();
            if (dto.getVenuePrice() != 0)
                existing = new Venue.Builder().copy(existing).setVenuePrice(dto.getVenuePrice()).build();
            if (dto.getVenueAddress() != null)
                existing = new Venue.Builder().copy(existing).setVenueAddress(dto.getVenueAddress()).build();
            if (dto.getVenueImage() != null)
                existing = new Venue.Builder().copy(existing).setVenueImage(dto.getVenueImage()).build();

            Venue updated = venueRepository.save(existing);
            return toDTO(updated);
        }
        return null;
    }



    public boolean delete(int venueId) {
        if (venueRepository.existsById(venueId)) {
            venueRepository.deleteById(venueId);
            return true;
        }
        return false;
    }


    public List<Venue> getAll() {
        return venueRepository.findAll();
    }


    public Venue updateVenueImage(int venueId, byte[] newImage) {
        Optional<Venue> optionalVenue = venueRepository.findById(venueId);
        if (optionalVenue.isPresent()) {
        Venue v = optionalVenue.get();
        v = new Venue.Builder()
                .copy(v)
                .setVenueImage(newImage)
                .build();
        return venueRepository.save(v);
        }
        return null;
    }

}//end of class
