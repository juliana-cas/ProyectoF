package co.edu.cue.flightsjuliana.services.impl;

import co.edu.cue.flightsjuliana.constraints.UserConstraint;
import co.edu.cue.flightsjuliana.domain.entities.User;
import co.edu.cue.flightsjuliana.mapping.dtos.UserDto;
import co.edu.cue.flightsjuliana.mapping.mappers.UserMapper;
import co.edu.cue.flightsjuliana.repositories.UserRepository;
import co.edu.cue.flightsjuliana.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserConstraint userConstraint;
    @Autowired
   // private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, UserConstraint userConstraint) {
        this.repository = repository;
        this.userConstraint = userConstraint;
    }

    @Override
    public List<UserDto> listUsers() {
        return UserMapper.mapFrom((List<User>) repository.findAll());
    }

    @Override
    public UserDto getUserById(int id) {
        return UserMapper.mapFrom(repository.findById(id).orElseThrow());
    }

    @Override
    public void save(UserDto user) {
        User saveUser = UserMapper.mapFrom(user);
        UserMapper.mapFrom(repository.save(saveUser));
    }

    @Override
    public UserDto update(UserDto user) {
        userConstraint.isUserNameAvailable(user.userName());
        return UserMapper.mapFrom(repository.save(UserMapper.mapFrom(user)));
    }
}
