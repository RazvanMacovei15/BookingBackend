package siemens.booking.dto;

import lombok.*;
import siemens.booking.model.RoomType;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RoomDto {
    private Long id;
    private RoomType type;
    private int number;
    private BigDecimal price;
}
