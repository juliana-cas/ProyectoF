package co.edu.cue.flightsjuliana.services;

import co.edu.cue.flightsjuliana.mapping.dtos.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> listUsers();
    UserDto getUserById(int id);
    void save(UserDto user);
    UserDto update(UserDto user);
}
