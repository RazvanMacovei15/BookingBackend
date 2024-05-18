package siemens.booking.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
@RequiredArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
public class UserReservation {
    private final Long id;
    private final String hotelName;
    private final int roomNumber;
    private final BigDecimal price;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final ReservationStatus status;

    @Override
    public String toString() {
        return "UserReservation{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", roomNumber=" + roomNumber +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                "}";
    }
}
