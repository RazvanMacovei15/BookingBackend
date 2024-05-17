package siemens.booking.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import siemens.booking.model.Room;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class HotelDto {
    private Long id;
    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private List<Room> rooms;
}
