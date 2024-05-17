package siemens.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import siemens.booking.entity.Reservation;

import java.time.LocalDate;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN 0 ELSE 1 END " +
            "FROM Room r LEFT JOIN Reservation b ON r.id = b.room.id " +
            "WHERE (b.startDate >= :startDate AND b.startDate < :endDate) " +
            "OR (b.endDate > :startDate AND b.endDate <= :endDate) " +
            "AND r.id = :roomId")
    int checkRoomAvailability(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("roomId") Long roomId
    );
}

