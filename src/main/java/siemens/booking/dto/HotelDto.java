package siemens.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class HotelDto {
    private final Long id;
    private final String name;
    private LocalTime checkInTime;
}
