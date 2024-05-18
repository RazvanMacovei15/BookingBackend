package siemens.booking.consoleapllication;

import java.math.BigDecimal;

public class ApiEndpoints {
    public static String generateHotelSearchByRadius(BigDecimal userLatitude, BigDecimal userLongitude, int radius) {
        return "http://localhost:8010/hotels?userLatitude="+userLatitude+"&userLongitude="+userLongitude+"&radius="+radius;
    }

    public static final String roomSearch (Long hotelId) {
        return "http://localhost:8010/rooms/available?hotelId="+hotelId;
    }
}
