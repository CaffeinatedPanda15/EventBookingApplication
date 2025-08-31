//Muhammad Siddeeq Rabin
//STUDENT :221084096
//Group kN13


package za.ac.cput.service;

import za.ac.cput.domain.eventdomains.Reservation;
import za.ac.cput.repository.eventrepositories.IReservationRepository;
import java.util.List;
import java.util.Optional;

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
        return repository.save(reservation);
    }

    @Override
    public Optional<Reservation> read(String reservationID) {
        return repository.findById(reservationID);
    }

    @Override
    public Reservation update(Reservation reservation) {
        return repository.update(Optional.ofNullable(reservation));
    }

    @Override
    public boolean delete(String reservationID) {
        return repository.delete(reservationID);
    }

    @Override
    public List<Reservation> getAll() {
        return repository.getAll();
    }


    public void confirmReservation(String reservationID) {
        Optional<Reservation> res = repository.findById(reservationID);
        if (res != null) {
            res.isPresent();
            repository.update(res);
        }
    }

    public void cancelReservation(String reservationID) {
        Optional<Reservation> res = repository.findById(reservationID);
        if (res != null) {
            res.isPresent();
            repository.update(res);
        }
    }
}
