package siemens.booking.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siemens.booking.entity.Room;
import siemens.booking.repository.RoomRepository;
import siemens.booking.services.RoomService;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository  roomRepository;
    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> findAvailableRooms(LocalDate startDate, LocalDate endDate, Long hotelId) {
        return roomRepository.findAvailableRooms(startDate, endDate, hotelId );
    }

    @Override
    public List<Room> getAllRoomsThatAreAvailable(Long hotelId) {
        return roomRepository.getAllRoomsThatAreAvailable(hotelId);
    }
}
