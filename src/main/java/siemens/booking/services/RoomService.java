package siemens.booking.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siemens.booking.dto.RoomDto;
import siemens.booking.entity.Room;
import siemens.booking.repository.RoomRepository;

import java.time.LocalDate;
import java.util.List;


public interface RoomService {

    Room save(Room room);

    List<Room> findAvailableRooms(LocalDate startDate, LocalDate endDate, Long hotelId);

    List<Room> getAllRoomsThatAreAvailable(Long hotelId);
}
