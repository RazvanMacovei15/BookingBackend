package siemens.booking.service;

import org.springframework.stereotype.Service;
import siemens.booking.domain.Room;
import siemens.booking.repos.HotelRepo;
import siemens.booking.repos.RoomRepo;

@Service
public class RoomService {
    private RoomRepo roomRepo;

    public RoomService() {

    }

    public void saveRoom(Room room){
        roomRepo.save(room);
    }
}
