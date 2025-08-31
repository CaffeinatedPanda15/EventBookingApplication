package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.EventApplication.models.Booking;
import za.ac.cput.EventApplication.repository.BookingRepo;
import za.ac.cput.EventApplication.services.BookingServices;
import za.ac.cput.EventApplication.services.iService;

import java.util.List;

@RestController
@RequestMapping("/api/bookings") // recommended for RESTful routes
public class BookingController {

    private final BookingServices bookingServices;

    @Autowired
    public BookingController(BookingServices bookingServices) {
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

        existing.setBookingDate(bookingData.getBookingDate());
        existing.setTicketID(bookingData.getTicketID());
        existing.setCustomerID(bookingData.getCustomerID());
        existing.setStatus(bookingData.getStatus());

        return new ResponseEntity<>(bookingServices.update(existing), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBooking(@PathVariable Long id) {
        bookingServices.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

