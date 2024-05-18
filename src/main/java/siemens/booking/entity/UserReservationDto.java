package siemens.booking.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import java.math.BigDecimal;
import java.time.LocalDate;

@RequiredArgsConstructor
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
