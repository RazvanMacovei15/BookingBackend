package siemens.booking.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siemens.booking.repository.RoomRepository;

@Service
@RequiredArgsConstructor
public class RoomService {
    private RoomRepository roomRepo;


}
