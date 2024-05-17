package siemens.booking.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Hotel {
    private Long id;
    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private List<Room> rooms;
}
