package co.edu.cue.flightsjuliana.mapping.mappers;

import co.edu.cue.flightsjuliana.domain.entities.User;
import co.edu.cue.flightsjuliana.mapping.dtos.UserDto;

import java.util.List;

public class UserMapper {
    public static UserDto mapFrom(User source) {
        return new UserDto(
                source.getUserId(),
                source.getUserName(),
                source.getPassword(),
                source.getEmail(),
                source.getPhone(),
                source.getGender()
        );
    }

    public static User mapFrom(UserDto source) {
        return new User(
                source.userId(),
                source.userName(),
                source.password(),
                source.email(),
                source.phone(),
                source.gender()
        );
    }

    public static List<UserDto> mapFrom(List<User> source){
        return source.parallelStream().map(e->mapFrom(e)).toList();
    }
}
