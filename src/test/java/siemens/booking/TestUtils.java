package siemens.booking;

import siemens.booking.domain.Hotel;

import java.math.BigDecimal;

public class TestUtils {
    public static Hotel createHotel() {
        return Hotel.builder()
                .id(1L)
                .name("Ramada")
//                .latitude(new BigDecimal("67.45674674"))
//                .longitude(new BigDecimal("67.45674674"))
                .build();
    }
}
