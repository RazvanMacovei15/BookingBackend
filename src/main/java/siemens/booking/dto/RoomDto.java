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

public class RoomDto {
    private Long id;
    private RoomType type;
    private int number;
    private BigDecimal price;

    @Override
    public String toString() {
        return id+". room number: "+ number + ", price: " + price + "RON";
    }
}
