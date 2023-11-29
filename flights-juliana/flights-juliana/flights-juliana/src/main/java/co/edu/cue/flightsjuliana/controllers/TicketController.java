package co.edu.cue.flightsjuliana.controllers;

import co.edu.cue.flightsjuliana.mapping.dtos.TicketDto;
import co.edu.cue.flightsjuliana.mapping.mappers.FlightMapper;
import co.edu.cue.flightsjuliana.services.FlightService;
import co.edu.cue.flightsjuliana.services.TicketService;
import co.edu.cue.flightsjuliana.services.UserService;
import co.edu.cue.flightsjuliana.services.impl.TicketServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@AllArgsConstructor
@RequestMapping("/ticket")
@Controller
public class TicketController {
    private final TicketService ticketService;
    private FlightService flightService;
    private final UserService userService;
    private final TicketServiceImpl ticketServiceImpl;

    public void TicketServiceImpl(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/create-ticket")
    public String createTicket(@RequestParam("flight") int flightId,
                               @RequestParam("purchaseDate")LocalDateTime purchaseDate,
                               @RequestParam("seat") int seatNumber,
                               @RequestParam("isPaid") Boolean isPaid
                               ){
        TicketDto ticketDto = TicketDto
                .builder()
                .flight(FlightMapper.mapFrom(flightService.getFlightById(flightId)))
                .purchaseDate(purchaseDate)
                .seatNumber(seatNumber)
                .isPaid(isPaid)
                .build();
        ticketService.save(ticketDto);
        return "redirect:/ticket/create?success";
    }

    @GetMapping("/ticket/create")
    public ModelAndView createReservationA(){
        ModelAndView modelAndView = new ModelAndView("ticketForm");
        modelAndView.addObject("flight", flightService.listFlights());
        return modelAndView;
    }

}