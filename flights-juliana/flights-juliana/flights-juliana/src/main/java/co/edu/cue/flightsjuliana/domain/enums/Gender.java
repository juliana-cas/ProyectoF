package co.edu.cue.flightsjuliana.domain.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Gender {
    M("Masculino"),
    F("Femenino"),
    N("Otro");

    Gender(String value) {
        this.value = value;
    }

    private String value;

    public static Gender fromValue(String value) {
        return Arrays.stream(Gender.values())
                .filter(e -> e.getValue().equalsIgnoreCase(value))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Status not found"));
    }
}