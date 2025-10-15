package za.ac.cput.service;

import za.ac.cput.domain.eventdomains.Venue;

import java.util.List;

public interface IVenueService {

    Venue create(Venue venue);

    Venue read(int venueId);

    Venue update(Venue venue);

    boolean delete(int venueId);

    List<Venue> getAll();


}
