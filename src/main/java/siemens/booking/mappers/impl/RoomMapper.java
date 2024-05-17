package siemens.booking.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import siemens.booking.dto.RoomDto;
import siemens.booking.entity.Room;
import siemens.booking.mappers.Mapper;
@Component
public class RoomMapper implements Mapper<Room, RoomDto> {
    private ModelMapper modelMapper;

    public RoomMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public RoomDto mapTo(Room room) {
        return modelMapper.map(room, RoomDto.class);
    }

    @Override
    public Room mapFrom(RoomDto roomDto) {
        return modelMapper.map(roomDto, Room.class);
    }
}
