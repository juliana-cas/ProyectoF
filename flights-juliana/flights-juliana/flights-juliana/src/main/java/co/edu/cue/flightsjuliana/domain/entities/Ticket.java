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
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;
    @Column(name = "seat_number")
    private int seatNumber;
    @Column(name = "is_paid")
    private Boolean isPaid;
}
