package siemens.booking.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siemens.booking.entity.Hotel;
import siemens.booking.repository.HotelRepository;
import siemens.booking.services.HotelService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private static final double EARTH_RADIUS = 6371.0;

    private final HotelRepository hotelRepository;

    @Override
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> searchHotels(BigDecimal userLatitude,
                                    BigDecimal userLongitude,
                                    BigDecimal radius) {
        List<Hotel> list = hotelRepository.findAll().stream()
                .filter(hotel -> isWithinRadius(hotel, userLatitude, userLongitude, radius))
                .toList();
        return list;
    }

    @Override
    public List<Hotel> getAllHotels() {
        return StreamSupport.stream(hotelRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    private boolean isWithinRadius(Hotel hotel, BigDecimal userLatitude, BigDecimal userLongitude, BigDecimal radius) {
       BigDecimal distance =  calculateDistance(hotel.getLatitude(), hotel.getLongitude(), userLatitude, userLongitude);
       return distance.compareTo(radius) <= 0;
    }

    private static BigDecimal calculateDistance(BigDecimal lat1, BigDecimal lon1, BigDecimal lat2, BigDecimal lon2) {
        // Convert latitude and longitude from degrees to radians
        double lat1Rad = Math.toRadians(lat1.doubleValue());
        double lon1Rad = Math.toRadians(lon1.doubleValue());
        double lat2Rad = Math.toRadians(lat2.doubleValue());
        double lon2Rad = Math.toRadians(lon2.doubleValue());

        // Calculate the differences
        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;

        // Haversine formula
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad)
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Distance in kilometers
        return BigDecimal.valueOf((EARTH_RADIUS * c)*1000);
    }
}
