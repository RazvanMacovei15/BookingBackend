package siemens.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import siemens.booking.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
