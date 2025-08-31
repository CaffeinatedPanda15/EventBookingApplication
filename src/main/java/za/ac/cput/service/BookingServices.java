package za.ac.cput.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.ac.cput.EventApplication.models.Booking;
import za.ac.cput.EventApplication.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServices implements iService<Booking, Long> {

    private final BookingRepo bookingRepository;

    @Autowired
    public BookingServices(BookingRepo bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking create(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking read(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking update(Booking booking) {
        if (bookingRepository.existsById(booking.getBookingId())) {
            return bookingRepository.save(booking);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
        }
    }

    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    public List<Booking> getBookingsByCustomerID(long customerID) {
        return bookingRepository.findAllByCustomerID(customerID);
    }

    public List<Booking> getBookingsByCustomerIDAndDate(long customerID, LocalDateTime bookingDate) {
        return bookingRepository.findAllByCustomerIDAndBookingDate(customerID, bookingDate);
    }

    public List<Booking> getBookingsByStatus(String status) {
        return bookingRepository.findAllByStatus(status);
    }


}
