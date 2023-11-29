package co.edu.cue.flightsjuliana.services;

import co.edu.cue.flightsjuliana.mapping.dtos.TicketDto;

import java.util.List;

public interface TicketService {
    List<TicketDto> listTickets();
    TicketDto getTicketById(int id);
    TicketDto save(TicketDto ticket);
    List<TicketDto> getTicketsByUser(String userName);
}