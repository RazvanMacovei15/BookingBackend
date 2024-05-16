package siemens.booking.domain;

import java.math.BigDecimal;
import java.util.List;

public class Hotel {
    private int id;
    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private List<Room> rooms;
}
