package siemens.booking.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
@ToString
public class UserReservationDto {
    private final Long id;
    private final String hotelName;
    private final int roomNumber;
    private final BigDecimal price;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int status;
}
