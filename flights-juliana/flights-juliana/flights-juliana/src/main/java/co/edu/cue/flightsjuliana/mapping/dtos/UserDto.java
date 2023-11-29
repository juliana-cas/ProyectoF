package co.edu.cue.flightsjuliana.mapping.dtos;

import co.edu.cue.flightsjuliana.domain.enums.Gender;
import lombok.Builder;

@Builder
public record UserDto(int userId,
        String userName,
        String password,
        String email,
        String phone,
        Gender gender) {
}