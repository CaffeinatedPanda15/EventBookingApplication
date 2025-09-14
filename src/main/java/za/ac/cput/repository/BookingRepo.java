package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.eventdomains.Booking;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {

    List<Booking> findAllByCustomerID(long customerID);

    List<Booking> findAllByCustomerIDAndBookingDate(long customerID, LocalDateTime bookingDate);

    List<Booking> findAllByStatus(String status);
}
