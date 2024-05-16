package siemens.booking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import siemens.booking.domain.Room;

public interface RoomRepo extends JpaRepository<Room, Long> {
}
