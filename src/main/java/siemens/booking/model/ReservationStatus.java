package siemens.booking.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ReservationStatus {
    ACTIVE(0),
    CANCELLED(1),
    FINISHED(2);

    private final int value;

    public static ReservationStatus valueOf(int value) {
        for (ReservationStatus reservationStatus : ReservationStatus.values()) {
            if (reservationStatus.getValue() == value) {
                return reservationStatus;
            }
        }
        throw new IllegalArgumentException("Invalid ReservationStatus value: " + value);
    }
}
