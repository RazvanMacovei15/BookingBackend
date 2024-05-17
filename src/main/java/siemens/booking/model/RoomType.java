package siemens.booking.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoomType {
    SINGLE(1),
    DOUBLE(2),
    SUITE(3),
    MATRIMONIAL(4);

    private final int value;

    public static RoomType valueOf(int value) {
        for (RoomType roomType : RoomType.values()) {
            if (roomType.getValue() == value) {
                return roomType;
            }
        }
        throw new IllegalArgumentException("Invalid RoomType value: " + value);
    }
}
