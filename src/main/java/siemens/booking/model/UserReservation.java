package siemens.booking.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@RequiredArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
@ToString
public class UserReservation {
    private final Long id;
    private final String hotelName;
    private final int roomNumber;
    private final BigDecimal price;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final ReservationStatus status;
}
