package siemens.booking.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import siemens.booking.dto.HotelDto;
import siemens.booking.entity.Hotel;
import siemens.booking.mappers.Mapper;

@Component
public class HotelMapper implements Mapper<Hotel, HotelDto> {

    private ModelMapper modelMapper;

    public HotelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public HotelDto mapTo(Hotel hotel) {
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public Hotel mapFrom(HotelDto hotelDto) {
        return modelMapper.map(hotelDto, Hotel.class);
    }
}
