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
@RequestMapping("/hotels")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class HotelController {

    private final HotelService hotelService;

    private Mapper<Hotel, HotelDto> hotelMapper;

    @PostMapping
    public HotelDto createHotel(@RequestBody HotelDto hotelDto){
        Hotel hotel = hotelMapper.mapFrom(hotelDto);
        Hotel savedHotel = hotelService.save(hotel);
        return hotelMapper.mapTo(savedHotel);
    }

    @GetMapping
    public List<HotelDto> searchHotels(@RequestParam BigDecimal userLatitude,
                                       @RequestParam BigDecimal userLongitude,
                                       @RequestParam BigDecimal radius){
        List<Hotel> hotels = hotelService.searchHotels(userLatitude, userLongitude, radius);
        System.out.println(hotels.size());
        return hotels.stream()
                .map(hotelMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping("/all")
    public List<HotelDto> getAllHotels(){
        List<Hotel> hotels = hotelService.getAllHotels();
        return hotels.stream()
                .map(hotelMapper::mapTo)
                .collect(Collectors.toList());
    }
}
