package siemens.booking.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import siemens.booking.dto.RoomDto;
import siemens.booking.entity.Room;
import siemens.booking.mappers.Mapper;
import siemens.booking.model.RoomType;

@Component
public class RoomMapper implements Mapper<Room, RoomDto> {
    private ModelMapper modelMapper;

    public RoomMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public RoomDto mapTo(Room room) {
        return RoomDto.builder()
                .id(room.getId())
                .number(room.getNumber())
                .type(RoomType.valueOf(room.getType()))
                .price(room.getPrice())
                .build();
    }

    @Override
    public Room mapFrom(RoomDto roomDto) {
        return Room.builder().
                id(roomDto.getId())
                .number(roomDto.getNumber())
                .type(roomDto.getType().getValue())
                .price(roomDto.getPrice())
                .build();
    }
}
