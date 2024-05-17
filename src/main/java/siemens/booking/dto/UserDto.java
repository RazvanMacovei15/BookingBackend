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
public class UserDto {
    private int id;
    private String fullName;
    private String email;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
