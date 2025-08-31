//Muhammad Siddeeq Rabin
//STUDENT :221084096
//Group kN13

package za.ac.cput.repository.eventrepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.eventdomains.Reservation;
import java.util.List;
import java.util.Optional;

public interface IReservationRepository extends JpaRepository<Reservation, String> {
    List<Reservation> findByEventId(String eventId);

    Reservation update(Optional<Reservation> reservation);

    boolean delete(String reservationID);

    List<Reservation> getAll();
}
