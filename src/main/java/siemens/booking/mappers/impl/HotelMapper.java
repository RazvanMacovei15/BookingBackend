package siemens.booking.mappers.impl;

import org.springframework.stereotype.Component;
import siemens.booking.dto.HotelDto;
import siemens.booking.entity.Hotel;
import siemens.booking.mappers.Mapper;

@Component
public class HotelMapper implements Mapper<Hotel, HotelDto> {

    @Override
    public HotelDto mapTo(Hotel hotel) {
        return HotelDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .checkInTime(hotel.getCheckInTime())
                .build();
    }

    @Override
    public Hotel mapFrom(HotelDto hotelDto) {
        return Hotel.builder()
                .id(hotelDto.getId())
                .name(hotelDto.getName())
                .checkInTime(hotelDto.getCheckInTime())
                .build();
    }
}
