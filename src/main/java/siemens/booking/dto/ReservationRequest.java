package siemens.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import siemens.booking.entity.Room;
import siemens.booking.entity.User;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class ReservationRequest {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Long userId;
    private final Long roomId;
}
