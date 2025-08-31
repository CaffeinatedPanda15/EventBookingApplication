//Muhammad Siddeeq Rabin
//STUDENT :221084096
//Group kN13

package za.ac.cput.service;

import za.ac.cput.domain.eventdomains.Ticket;
import za.ac.cput.repository.endusers.ITicketRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketService implements ITicketService {

    private final ITicketRepository repository;

    // Constructor injection
    public TicketService(ITicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ticket create(Ticket ticket) {
        return repository.create(ticket);
    }

    @Override
    public Ticket read(int ticketID) {
        return repository.read(ticketID);
    }

    @Override
    public Ticket update(Ticket ticket) {
        return repository.update(ticket);
    }

    @Override
    public boolean delete(int ticketID) {
        return repository.delete(ticketID);
    }

    @Override
    public List<Ticket> getAll() {
        return repository.getAll();
    }
}
