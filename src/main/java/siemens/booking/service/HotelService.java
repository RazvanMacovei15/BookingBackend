package siemens.booking.service;

import org.springframework.stereotype.Service;
import siemens.booking.domain.Hotel;
import siemens.booking.repos.HotelRepo;

@Service
public class HotelService {
    private HotelRepo hotelRepo;

    public void saveHotel(Hotel hotel){
        hotelRepo.save(hotel);
    }
}
