//Muhammad Siddeeq Rabin
//STUDENT :221084096
//Group kN13

package za.ac.cput.service;

import za.ac.cput.domain.eventdomains.Reservation;
import java.util.List;

public interface IReservationService {
    Reservation create(Reservation reservation);
    Reservation read(String reservationID);
    Reservation update(Reservation reservation);
    boolean delete(String reservationID);
    List<Reservation> getAll();
}

