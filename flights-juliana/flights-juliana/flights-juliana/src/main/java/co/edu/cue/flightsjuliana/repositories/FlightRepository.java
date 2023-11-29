package co.edu.cue.flightsjuliana.repositories;

import co.edu.cue.flightsjuliana.domain.entities.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Integer> {
}
