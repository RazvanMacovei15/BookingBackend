package siemens.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalTime;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode

public class HotelDto {
    private final Long id;
    private final String name;
    private final LocalTime checkInTime;

    @Override
    public String toString() {
        return id + ". " + name;
    }
}
