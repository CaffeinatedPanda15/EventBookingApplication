

//Muhammad Siddeeq Rabin
//STUDENT :221084096
//Group kN13

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.eventdomains.Reservation;
import za.ac.cput.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService service;

    @Autowired
    public ReservationController(ReservationService service) {
        this.service = service;
    }

    // Create a reservation
    @PostMapping("/create")
    public Reservation create(@RequestBody Reservation reservation) {
        return service.create(reservation);
    }

    // Read a reservation by ID
    @GetMapping("/read/{id}")
    public Reservation read(@PathVariable("id") String reservationID) {
        return service.read(reservationID);
    }

    // Update a reservation
    @PutMapping("/update")
    public Reservation update(@RequestBody Reservation reservation) {
        return service.update(reservation);
    }

    // Delete a reservation by ID
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") String reservationID) {
        return service.delete(reservationID);
    }

    // Get all reservations
    @GetMapping("/getAll")
    public List<Reservation> getAll() {
        return service.getAll();
    }

    // Domain-specific actions
    @PutMapping("/confirm/{id}")
    public void confirmReservation(@PathVariable("id") String reservationID) {
        service.confirmReservation(reservationID);
    }

    @PutMapping("/cancel/{id}")
    public void cancelReservation(@PathVariable("id") String reservationID) {
        service.cancelReservation(reservationID);
    }
}
