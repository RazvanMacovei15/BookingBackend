package siemens.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import siemens.booking.entity.Room;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT r FROM Room r " +
            "LEFT JOIN Reservation rs " + "ON r.id = rs.room.id " +
            "WHERE r.hotel.id = :hotelId " +
            "AND r.isAvailable = true " +
            "AND (rs.startDate IS NULL " +
            "OR (rs.startDate >= :startDate AND rs.endDate < :endDate) " +
            "OR (rs.endDate > :startDate AND rs.startDate <= :endDate))" +
            "AND (rs.status is null or rs.status != 1)")
    List<Room> findAvailableRooms(@Param("startDate") LocalDate startDate,
                                  @Param("endDate") LocalDate endDate,
                                  @Param("hotelId") Long hotelId);

    @Query("SELECT r FROM Room r LEFT JOIN r.hotel h ON h.id = r.hotel.id WHERE h.id = :hotelId AND r.isAvailable = true")
    List<Room> getAllRoomsThatAreAvailable(@Param("hotelId") Long hotelId);
}
