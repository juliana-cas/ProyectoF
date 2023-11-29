package co.edu.cue.flightsjuliana.services.impl;

import co.edu.cue.flightsjuliana.domain.entities.Flight;
import co.edu.cue.flightsjuliana.mapping.dtos.FlightDto;
import co.edu.cue.flightsjuliana.mapping.mappers.FlightMapper;
import co.edu.cue.flightsjuliana.repositories.FlightRepository;
import co.edu.cue.flightsjuliana.services.FlightService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository repository;

    public FlightServiceImpl(FlightRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FlightDto> listFlights() {
        return FlightMapper.mapFrom((List<Flight>)repository.findAll());
    }

    @Override
    public FlightDto getFlightById(int id) {
        return FlightMapper.mapFrom(
                repository.findById(id).orElseThrow());
    }

    @Override
    public FlightDto update(FlightDto flight) {
        return FlightMapper.mapFrom(
                repository.save(FlightMapper.mapFrom(flight))
        );
    }
}