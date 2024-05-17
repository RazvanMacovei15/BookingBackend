package siemens.booking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "HOTELS")
public class Hotel {
    @Id
    private Long id;
    private String name;
    @Column(nullable = false, precision = 10, scale = 8)
    private BigDecimal latitude;
    @Column(nullable = false, precision = 10, scale = 8)
    private BigDecimal longitude;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Room> rooms;

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return id.equals(hotel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                '}';
    }
}
