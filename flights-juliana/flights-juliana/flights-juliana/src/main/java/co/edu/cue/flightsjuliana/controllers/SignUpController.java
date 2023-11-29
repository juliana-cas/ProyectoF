package co.edu.cue.flightsjuliana.controllers;

import co.edu.cue.flightsjuliana.exceptions.UserException;
import co.edu.cue.flightsjuliana.mapping.dtos.UserDto;
import co.edu.cue.flightsjuliana.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SignUpController {
    private final UserService service;

    public SignUpController(UserService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

    @GetMapping("/sign-up")
    public String signUpForm(){
        return "login/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(UserDto userDto, Model model, RedirectAttributes redirectAttributes){
        try {
            service.save(userDto);

        }catch (UserException e){
            redirectAttributes.addFlashAttribute("usernameError", e.getMessage());
            return "redirect:/user-list";
        }
        return "redirect:/login";
    }
}
