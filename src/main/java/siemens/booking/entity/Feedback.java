package siemens.booking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "FEEDBACKS")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_id_seq")
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "cleanliness")
    private int cleanliness;
    @Column(name = "comfort")
    private int comfort;
    @Column(name = "location")
    private int location;
    @Column(name = "staff")
    private int staff;
    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
