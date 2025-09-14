package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.eventdomains.Booking;
import za.ac.cput.service.Services;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final Services bookingServices;

    @Autowired
    public BookingController(Services bookingServices) {
        this.bookingServices = bookingServices;
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingServices.getAll();
        if (bookings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Booking booking = bookingServices.read(id);
        if (booking == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        Booking saved = bookingServices.create(booking);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking bookingData) {
        Booking existing = bookingServices.read(id);
        if (existing == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Booking updatedBooking = new Booking.Builder()
                .copy(existing)
                .setBookingDate(bookingData.getBookingDate())
                .setTicketID(bookingData.getTicketID())
                .setCustomerID(bookingData.getCustomerID())
                .setStatus(bookingData.getStatus())
                .build();

        return new ResponseEntity<>(bookingServices.update(updatedBooking), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBooking(@PathVariable Long id) {
        bookingServices.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

