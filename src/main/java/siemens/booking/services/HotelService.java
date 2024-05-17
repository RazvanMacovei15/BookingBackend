package siemens.booking.services;

import siemens.booking.entity.Hotel;

import java.math.BigDecimal;
import java.util.List;


public interface HotelService {
    Hotel save(Hotel hotel);
    List<Hotel> searchHotels(BigDecimal userLatitude,
                             BigDecimal userLongitude,
                             BigDecimal radius);
}
