package siemens.booking.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import siemens.booking.enums.RoomType;

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
    private Long id;
    private RoomType roomType;
    private int roomNumber;
    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal price;
    private boolean isAvailable;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
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
                ", roomNumber=" + roomNumber +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", hotel=" + hotel +
                '}';
    }
}
