package siemens.booking.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siemens.booking.entity.Hotel;
import siemens.booking.repository.HotelRepository;
import siemens.booking.services.HotelService;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;


    @Override
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}
