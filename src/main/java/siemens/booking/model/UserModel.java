package siemens.booking.model;

import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserModel {
    private int id;
    private String fullName;
    private String email;
}
