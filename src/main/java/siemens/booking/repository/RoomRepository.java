package siemens.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siemens.booking.entity.Room;
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
