//Muhammad Siddeeq Rabin
//STUDENT :221084096
//Group kN13

package za.ac.cput.service.Iservice;

import za.ac.cput.domain.eventdomains.Reservation;
import java.util.List;
import java.util.Optional;

public interface IReservationService {
    Reservation create(Reservation reservation);
    Optional<Reservation> read(String reservationID);
    Reservation update(Reservation reservation);
    boolean delete(String reservationID);
    List<Reservation> getAll();
}
