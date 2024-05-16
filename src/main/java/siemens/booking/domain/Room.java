package siemens.booking.domain;

import siemens.booking.enums.RoomType;

import java.math.BigDecimal;

public class Room {
    private RoomType roomType;
    private int roomNumber;
    private BigDecimal price;
    private boolean isAvailable;
}
