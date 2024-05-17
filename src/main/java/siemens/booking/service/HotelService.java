package siemens.booking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siemens.booking.dto.requests.SaveHotelRequest;
import siemens.booking.entity.Hotel;
import siemens.booking.repository.HotelRepository;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;

    public long save(SaveHotelRequest request) {
        Hotel hotel = Hotel.builder()
                .id(request.getId())
                .name(request.getName())
                .longitude(request.getLongitude())
                .latitude(request.getLatitude())
                .build();

        Hotel savedHotel = hotelRepository.save(hotel);
        return savedHotel.getId();
    }
}
