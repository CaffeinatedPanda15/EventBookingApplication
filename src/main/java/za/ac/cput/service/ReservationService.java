//Muhammad Siddeeq Rabin
//STUDENT :221084096
//Group kN13

package za.ac.cput.service;

import za.ac.cput.domain.eventdomains.Reservation;
import za.ac.cput.repository.IReservationRepository;
import java.util.List;

public class ReservationService implements IReservationService {

    private static ReservationService service = null;
    private IReservationRepository repository;

    private ReservationService(IReservationRepository repository) {
        this.repository = repository;
    }

    public static ReservationService getService(IReservationRepository repository) {
        if (service == null) {
            service = new ReservationService(repository);
        }
        return service;
    }

    @Override
    public Reservation create(Reservation reservation) {
        return repository.create(reservation);
    }

    @Override
    public Reservation read(String reservationID) {
        return repository.read(reservationID);
    }

    @Override
    public Reservation update(Reservation reservation) {
        return repository.update(reservation);
    }

    @Override
    public boolean delete(String reservationID) {
        return repository.delete(reservationID);
    }

    @Override
    public List<Reservation> getAll() {
        return repository.getAll();
    }

    // Extra convenience methods for your domain (optional)
    public void confirmReservation(String reservationID) {
        Reservation res = repository.read(reservationID);
        if (res != null) {
            res.confirmReservation();
            repository.update(res);
        }
    }

    public void cancelReservation(String reservationID) {
        Reservation res = repository.read(reservationID);
        if (res != null) {
            res.cancelReservation();
            repository.update(res);
        }
    }
}
