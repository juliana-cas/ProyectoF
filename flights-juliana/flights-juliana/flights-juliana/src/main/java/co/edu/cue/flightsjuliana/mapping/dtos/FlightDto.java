package co.edu.cue.flightsjuliana.mapping.dtos;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record FlightDto(int flightId,
        String origin,
        String destination,
        LocalDateTime departTime,
        LocalDateTime arrivalTime,
        int capacity,
        double economyPrice) {
}