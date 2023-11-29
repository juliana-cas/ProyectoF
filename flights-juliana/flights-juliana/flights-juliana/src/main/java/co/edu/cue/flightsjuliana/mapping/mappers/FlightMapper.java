package co.edu.cue.flightsjuliana.mapping.mappers;

import co.edu.cue.flightsjuliana.domain.entities.Flight;
import co.edu.cue.flightsjuliana.domain.entities.Ticket;
import co.edu.cue.flightsjuliana.domain.entities.User;
import co.edu.cue.flightsjuliana.mapping.dtos.FlightDto;
import co.edu.cue.flightsjuliana.mapping.dtos.TicketDto;
import co.edu.cue.flightsjuliana.mapping.dtos.UserDto;

import java.util.List;

public class FlightMapper {
    public static FlightDto mapFrom(Flight source) {
        return new FlightDto(
                source.getFlightId(),
                source.getOrigin(),
                source.getDestination(),
                source.getDepartTime(),
                source.getArrivalTime(),
                source.getCapacity(),
                source.getEconomyPrice()
        );
    }

    public static Flight mapFrom(FlightDto source) {
        return new Flight(
                source.flightId(),
                source.origin(),
                source.destination(),
                source.departTime(),
                source.arrivalTime(),
                source.capacity(),
                source.economyPrice()
        );
    }

    public static List<FlightDto> mapFrom(List<Flight> source){
        return source.parallelStream().map(e->mapFrom(e)).toList();
    }
}