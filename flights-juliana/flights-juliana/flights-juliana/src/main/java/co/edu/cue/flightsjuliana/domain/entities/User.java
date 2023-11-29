package co.edu.cue.flightsjuliana.domain.entities;

import co.edu.cue.flightsjuliana.domain.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//listo

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String password;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
