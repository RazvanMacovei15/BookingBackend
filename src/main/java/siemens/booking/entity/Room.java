package siemens.booking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
@Table(name = "ROOMS")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_id_seq")
    private Long id;
    @Column(name = "type")
    private int type;
    @Column(name = "number")
    private int number;
    @Column(precision = 5, scale = 2, name = "price" )
    private BigDecimal price;
    @Column(name = "isAvailable")
    private boolean isAvailable;
    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotel;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reservation> reservations;
}
