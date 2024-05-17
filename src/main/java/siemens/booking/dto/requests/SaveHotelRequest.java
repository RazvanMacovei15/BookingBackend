package siemens.booking.dto.requests;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class SaveHotelRequest {
    private final Long id;
    private final String name;
    private final BigDecimal latitude;
    private final BigDecimal longitude;
}
