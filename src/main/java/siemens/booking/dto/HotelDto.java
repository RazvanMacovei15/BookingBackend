package siemens.booking.dto;

import lombok.*;

import java.time.LocalTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class HotelDto {
    private  Long id;
    private  String name;
    private  LocalTime checkInTime;
}
