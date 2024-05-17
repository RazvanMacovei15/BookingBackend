package siemens.booking.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import siemens.booking.entity.Hotel;
import siemens.booking.entity.Reservation;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ReservationDto {
    private Long id;
    private int type;
    private int number;
    private BigDecimal price;
    private boolean isAvailable;
    private Hotel hotel;
    private List<Reservation> reservations;
}