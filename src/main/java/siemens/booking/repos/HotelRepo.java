package siemens.booking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siemens.booking.domain.Hotel;
@Repository
public interface HotelRepo extends JpaRepository<Hotel, Long> {
}
