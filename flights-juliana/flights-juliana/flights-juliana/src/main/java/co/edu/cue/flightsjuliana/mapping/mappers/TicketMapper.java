package co.edu.cue.flightsjuliana.mapping.mappers;

import co.edu.cue.flightsjuliana.domain.entities.Flight;
import co.edu.cue.flightsjuliana.domain.entities.Ticket;
import co.edu.cue.flightsjuliana.domain.entities.User;
import co.edu.cue.flightsjuliana.mapping.dtos.FlightDto;
import co.edu.cue.flightsjuliana.mapping.dtos.TicketDto;
import co.edu.cue.flightsjuliana.mapping.dtos.UserDto;

import java.util.List;

public class TicketMapper {
    public static TicketDto mapFrom(Ticket source) {
        return new TicketDto(
                source.getTicketId(),
                source.getUser(),
                source.getFlight(),
                source.getPurchaseDate(),
                source.getSeatNumber(),
                source.getIsPaid()
        );
    }

    public static Ticket mapFrom(TicketDto source) {
        return new Ticket(
                source.ticketId(),
                source.user(),
                source.flight(),
                source.purchaseDate(),
                source.seatNumber(),
                source.isPaid()
        );
    }

    public static List<TicketDto> mapFrom(List<Ticket> source){
        return source.parallelStream().map(e->mapFrom(e)).toList();
    }
}
