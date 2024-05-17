package siemens.booking.enums;

public enum RoomType {
    SINGLE('1'),
    DOUBLE('2'),
    SUITE('3'),
    MATRIMONIAL('4');

    private int value;

    RoomType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RoomType valueOf(int value) {
        for (RoomType roomType : RoomType.values()) {
            if (roomType.getValue() == value) {
                return roomType;
            }
        }
        throw new IllegalArgumentException("Invalid RoomType value: " + value);
    }
}
