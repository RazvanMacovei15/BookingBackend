package siemens.booking.dto.requests;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;
import siemens.booking.entity.Room;
import siemens.booking.entity.User;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SaveReservationRequest {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private User user;
    private Room room;
}
