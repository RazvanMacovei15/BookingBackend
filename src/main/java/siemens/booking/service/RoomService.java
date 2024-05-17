package siemens.booking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siemens.booking.entity.Room;
import siemens.booking.repository.RoomRepository;

@Service
@RequiredArgsConstructor
public class RoomService {
    private RoomRepository roomRepo;


}
