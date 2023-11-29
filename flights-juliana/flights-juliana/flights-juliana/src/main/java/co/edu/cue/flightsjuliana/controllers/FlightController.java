package co.edu.cue.flightsjuliana.controllers;

import co.edu.cue.flightsjuliana.services.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@RequestMapping("/flights")
@Controller
public class FlightController {
    private final FlightService flightService;

    @GetMapping("/list")
    public ModelAndView listFlights(){
        ModelAndView modelAndView = new ModelAndView("flightsList");
        modelAndView.addObject("flightsList", flightService.listFlights());
        return modelAndView;
    }

    @GetMapping("/update")
    public ModelAndView updateFlight(){
        ModelAndView modelAndView = new ModelAndView("flightsUpdate");
        modelAndView.addObject("flightsList", flightService.listFlights());
        return modelAndView;
    }

}
