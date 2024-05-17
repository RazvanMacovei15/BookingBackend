package siemens.booking.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import siemens.booking.dto.requests.HotelDto;
import siemens.booking.entity.Hotel;
import siemens.booking.mappers.Mapper;
import siemens.booking.services.HotelService;

@RestController
@AllArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    private Mapper<Hotel, HotelDto> hotelMapper;

    @PostMapping(path = "/hotels")
    public HotelDto createHotel(@RequestBody HotelDto hotelDto){
        Hotel hotel = hotelMapper.mapFrom(hotelDto);
        Hotel savedHotel = hotelService.save(hotel);
        return hotelMapper.mapTo(savedHotel);
    }

}
