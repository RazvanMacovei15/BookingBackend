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
}
