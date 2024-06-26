package siemens.booking.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import siemens.booking.dto.LocationDto;
import siemens.booking.entity.Location;
import siemens.booking.mappers.Mapper;
@Component
public class LocationMapper implements Mapper<Location, LocationDto>
{
    private final ModelMapper modelMapper;

    public LocationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public LocationDto mapTo(Location location) {
        return modelMapper.map(location, LocationDto.class);
    }

    @Override
    public Location mapFrom(LocationDto locationDto) {
        return modelMapper.map(locationDto, Location.class);
    }
}
