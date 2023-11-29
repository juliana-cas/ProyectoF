package co.edu.cue.flightsjuliana.constraints;

import co.edu.cue.flightsjuliana.exceptions.UserException;
import co.edu.cue.flightsjuliana.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserConstraint {
    private final UserRepository userRepository;

    public void isUserNameAvailable(String userName) throws UserException {
        userRepository.findByUserName(userName).ifPresent(user -> {
            throw new UserException("Por favor ingrese un nombre de usuario distinto.");
        });
    }
}
