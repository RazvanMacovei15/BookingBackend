package siemens.booking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_id_seq")
    private Long id;
    @Column(name = "type")
    private int type;
    @Column(name = "number")
    private int number;
    @Column(nullable = false, precision = 5, scale = 2, name = "price" )
    private BigDecimal price;
    @Column(name = "isAvailable")
    private boolean isAvailable;
    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber=" + number +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", hotel=" + hotel +
                '}';
    }
}
