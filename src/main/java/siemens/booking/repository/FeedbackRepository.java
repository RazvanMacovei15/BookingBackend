package siemens.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import siemens.booking.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
