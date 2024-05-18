package siemens.booking.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class FeedbackDto {
    private Long id;
    private String description;
    private int cleanliness;
    private int comfort;
    private int location;
    private int staff;
}
