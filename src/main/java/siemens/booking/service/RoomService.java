package siemens.booking.service;

import org.springframework.stereotype.Service;
import siemens.booking.entity.Room;
import siemens.booking.repository.RoomRepository;

@Service
public class RoomService {
    private RoomRepository roomRepo;

    public RoomService(RoomRepository roomRepo) {
        this.roomRepo = roomRepo;
    }

    public RoomService() {
    }

    public void saveRoom(Room room){
        roomRepo.save(room);
    }
}
