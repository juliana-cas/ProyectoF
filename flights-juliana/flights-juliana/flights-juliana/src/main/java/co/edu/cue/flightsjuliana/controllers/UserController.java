package co.edu.cue.flightsjuliana.controllers;

import co.edu.cue.flightsjuliana.mapping.dtos.UserDto;
import co.edu.cue.flightsjuliana.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/public")
@Controller
public class UserController {
    private final UserService service;


    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        List<UserDto> userList;
        userList = service.listUsers();
        model.addAttribute("user", userList);
        return "user-list";
    }


}