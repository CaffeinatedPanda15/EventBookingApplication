package za.ac.cput.repository.eventrepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.eventdomains.Booking;


@Repository
public interface IBookingRepository extends JpaRepository<Booking, Long> {

}
