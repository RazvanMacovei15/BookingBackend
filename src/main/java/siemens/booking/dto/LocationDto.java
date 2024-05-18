package siemens.booking.dto;

import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LocationDto {
    private BigDecimal latitude;
    private BigDecimal longitude;
}
