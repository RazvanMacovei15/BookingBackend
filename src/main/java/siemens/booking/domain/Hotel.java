package siemens.booking.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
@Entity
@Builder
@Table(name = "hotels")
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_id_seq")
    private Long id;
    private String name;
//    @Column(nullable = false, precision = 4, scale = 12)
//    private BigDecimal latitude;
//    @Column(nullable = false, precision = 4, scale = 12)
//    private BigDecimal longitude;
    @Transient
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public BigDecimal getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(BigDecimal latitude) {
//        this.latitude = latitude;
//    }
//
//    public BigDecimal getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(BigDecimal longitude) {
//        this.longitude = longitude;
//    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return id == hotel.id;
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
