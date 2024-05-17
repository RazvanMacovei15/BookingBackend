package siemens.booking.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import siemens.booking.dto.RoomDto;
import siemens.booking.entity.Room;
import siemens.booking.mappers.Mapper;
import siemens.booking.services.RoomService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rooms")
@AllArgsConstructor
public class RoomController {

    private final RoomService roomService;

    private Mapper<Room, RoomDto> roomMapper;

    @PostMapping
    public RoomDto createRoom(@RequestBody RoomDto roomDto){
        Room room = roomMapper.mapFrom(roomDto);
        Room savedRoom = roomService.save(room);
        return roomMapper.mapTo(savedRoom);
    }

    @GetMapping
    public List<RoomDto> findAvailableRooms(@RequestParam LocalDate startDate,
                                            @RequestParam LocalDate endDate,
                                            @RequestParam Long hotelId){
        List<Room> availableRooms =  roomService.findAvailableRooms(startDate, endDate, hotelId);
        return availableRooms.stream()
                .map(roomMapper::mapTo)
                .collect(Collectors.toList());
    }
}
