package siemens.booking.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import siemens.booking.dto.HotelDto;
import siemens.booking.entity.Hotel;
import siemens.booking.mappers.Mapper;
import siemens.booking.services.HotelService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping(path = "/hotels")
    public List<HotelDto> searchHotels(@RequestParam BigDecimal userLatitude,
                                       @RequestParam BigDecimal userLongitude,
                                       @RequestParam BigDecimal radius){
        List<Hotel> hotels = hotelService.searchHotels(userLatitude, userLongitude, radius);
        return hotels.stream()
                .map(hotelMapper::mapTo)
                .collect(Collectors.toList());
    }
}
