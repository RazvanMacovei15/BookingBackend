package siemens.booking.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siemens.booking.repository.HotelRepository;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;

}
