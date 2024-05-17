package siemens.booking.dto.requests;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import java.math.BigDecimal;

@Builder
@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class SaveHotelRequest {
    private final Long id;
    private final String name;
    private final BigDecimal latitude;
    private final BigDecimal longitude;
}
