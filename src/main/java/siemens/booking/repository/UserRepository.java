package siemens.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import siemens.booking.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
