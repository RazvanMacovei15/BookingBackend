package siemens.booking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    private int id;
    @Column(name = "fullName", nullable = false, length = 50)
    private String fullName;
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reservation> reservations;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;
}
