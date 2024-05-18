package siemens.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

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
