package co.edu.cue.flightsjuliana.mapping.dtos;

import co.edu.cue.flightsjuliana.domain.entities.Flight;
import co.edu.cue.flightsjuliana.domain.entities.User;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TicketDto(int ticketId,
        User user,
        Flight flight,
        LocalDateTime purchaseDate,
        int seatNumber,
        Boolean isPaid) {
}