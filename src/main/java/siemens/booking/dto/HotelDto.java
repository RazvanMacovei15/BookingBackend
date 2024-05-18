package siemens.booking.dto;

import lombok.*;

import java.time.LocalTime;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class HotelDto {
    private final Long id;
    private final String name;
    private final LocalTime checkInTime;
}
