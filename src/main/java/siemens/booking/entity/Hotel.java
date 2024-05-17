package siemens.booking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "HOTELS")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_id_seq")
    private Long id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(nullable = false, precision = 10, scale = 8, name = "latitude")
    private BigDecimal latitude;
    @Column(nullable = false, precision = 10, scale = 8, name = "longitude")
    private BigDecimal longitude;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Room> rooms;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;
}
