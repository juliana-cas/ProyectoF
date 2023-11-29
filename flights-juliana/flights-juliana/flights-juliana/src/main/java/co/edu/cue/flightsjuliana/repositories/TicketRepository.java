package co.edu.cue.flightsjuliana.repositories;

import co.edu.cue.flightsjuliana.domain.entities.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {
}
