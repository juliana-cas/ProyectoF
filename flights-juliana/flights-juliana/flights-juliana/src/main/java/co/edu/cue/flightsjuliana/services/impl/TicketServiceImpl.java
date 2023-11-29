package co.edu.cue.flightsjuliana.services.impl;

import co.edu.cue.flightsjuliana.domain.entities.Ticket;
import co.edu.cue.flightsjuliana.mapping.dtos.TicketDto;
import co.edu.cue.flightsjuliana.mapping.mappers.TicketMapper;
import co.edu.cue.flightsjuliana.repositories.TicketRepository;
import co.edu.cue.flightsjuliana.services.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository repository;

    public TicketServiceImpl(TicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TicketDto> listTickets() {
        return TicketMapper.mapFrom((List<Ticket>) repository.findAll());
    }

    @Override
    public TicketDto getTicketById(int id) {
        return TicketMapper.mapFrom(repository.findById(id).orElseThrow());
    }

    @Override
    public TicketDto save(TicketDto ticket) {
        return TicketMapper.mapFrom(repository.save(TicketMapper.mapFrom(ticket)));
    }

    @Override
    public List<TicketDto> getTicketsByUser(String userName) {
        return listTickets().stream()
                .filter(ticket -> ticket.user().getUserName().equals(userName)).toList();
    }
}