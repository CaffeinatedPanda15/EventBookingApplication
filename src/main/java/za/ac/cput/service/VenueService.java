package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.eventdomains.Venue;
import za.ac.cput.repository.eventrepositories.IVenueRepository;

import java.util.List;
import java.util.Optional;


@Service
public class VenueService implements IVenueService {

    private final IVenueRepository venueRepository;

    public VenueService(IVenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }


    @Override
    public Venue create(Venue venue) {
        return venueRepository.save(venue);
    }

    @Override
    public Venue read(int venueId) {
        Optional<Venue> venue = venueRepository.findById(venueId);
        return venue.orElse(null);
    }

    @Override
    public Venue update(Venue venue) {
        if (venueRepository.existsById(venue.getVenueId())) {
            return venueRepository.save(venue);
        }
        return null;
    }

    @Override
    public boolean delete(int venueId) {
        if (venueRepository.existsById(venueId)) {
            venueRepository.deleteById(venueId);
            return true;
        }
        return false;
    }

    @Override
    public List<Venue> getAll() {
        return venueRepository.findAll();
    }

    @Override
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
