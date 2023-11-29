package co.edu.cue.flightsjuliana.services;

import co.edu.cue.flightsjuliana.domain.entities.Flight;
import co.edu.cue.flightsjuliana.mapping.dtos.FlightDto;

import java.util.List;

public interface FlightService {
    List<FlightDto> listFlights();
    FlightDto getFlightById(int id);
    FlightDto update(FlightDto flight);
}
