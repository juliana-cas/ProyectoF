package co.edu.cue.flightsjuliana.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping("")
    public String index(Model model){
        return "index";
    }
}
