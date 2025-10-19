package za.ac.cput.service.Iservice;

import za.ac.cput.domain.eventdomains.Venue;

import java.util.List;

public interface IVenueService {

    Venue createVenue(Venue venue);

    Venue read(int venueId);

    Venue update(Venue venue);

    boolean delete(int venueId);

    List<Venue> getAll();


}
