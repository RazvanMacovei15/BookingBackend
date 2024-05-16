package siemens.booking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import siemens.booking.domain.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Long> {
}
