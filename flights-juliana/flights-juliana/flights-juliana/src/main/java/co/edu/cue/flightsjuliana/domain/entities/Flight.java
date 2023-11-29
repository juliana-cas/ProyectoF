package co.edu.cue.flightsjuliana.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private int flightId;
    private String origin;
    private String destination;
    @Column(name = "depart_time")
    private LocalDateTime departTime;
    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;
    private int capacity;
    @Column(name = "economy_price")
    private double economyPrice;
}