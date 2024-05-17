package siemens.booking.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Room {
    private Long id;
    private RoomType type;
    private int number;
    private BigDecimal price;
    private boolean isAvailable;
}
