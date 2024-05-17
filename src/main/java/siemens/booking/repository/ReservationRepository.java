package siemens.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import siemens.booking.entity.Reservation;
import siemens.booking.entity.UserReservationDto;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT new siemens.booking.entity.UserReservationDto (h.name, r.number, r.price, rs.startDate, rs.endDate, rs.status) " +
            "FROM Reservation rs " +
            "INNER JOIN rs.room r " +
            "INNER JOIN rs.user u " +
            "INNER JOIN r.hotel h " +
            "WHERE u.id = :userId")
    List<UserReservationDto> findUserReservations(@Param("userId") Long userId);

}

