package siemens.booking.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siemens.booking.dto.requests.ReservationDto;
import siemens.booking.dto.requests.SaveReservationRequest;
import siemens.booking.entity.Reservation;
import siemens.booking.repository.ReservationRepository;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public long save(ReservationDto request) {
        Reservation reservation = Reservation.builder()
                .id(request.getId())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .user(request.getUser())
                .room(request.getRoom())
                .build();

        Reservation savedReservation = reservationRepository.save(reservation);
        return savedReservation.getId();
    }

//    public int customQuery(Room room) {
//        return reservationRepository.checkRoomAvailability(LocalDate.parse("2021-01-01"), LocalDate.parse("2021-01-02"), room.getId());
//    }
}
