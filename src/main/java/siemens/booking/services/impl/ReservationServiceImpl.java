package siemens.booking.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siemens.booking.dto.ReservationRequest;
import siemens.booking.entity.Reservation;
import siemens.booking.entity.Room;
import siemens.booking.model.ReservationStatus;
import siemens.booking.model.UserReservation;
import siemens.booking.repository.ReservationRepository;
import siemens.booking.repository.RoomRepository;
import siemens.booking.repository.UserRepository;
import siemens.booking.services.ReservationService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    @Override
    public Reservation reserveRoom(ReservationRequest reservationRequest) {
        Reservation reservation = Reservation.builder()
                .user(userRepository.getReferenceById(reservationRequest.getUserId()))
                .room(roomRepository.getReferenceById(reservationRequest.getRoomId()))
                .startDate(reservationRequest.getStartDate())
                .endDate(reservationRequest.getEndDate())
                .status(0)
                .build();
        return reservationRepository.save(reservation);
    }

    @Override
    public List<UserReservation> getUserReservations(Long userId) {
        return reservationRepository.findUserReservations(userId).stream()
                .map(userReservationDto -> UserReservation.builder()
                        .hotelName(userReservationDto.getHotelName())
                        .roomNumber(userReservationDto.getRoomNumber())
                        .price(userReservationDto.getPrice())
                        .startDate(userReservationDto.getStartDate())
                        .endDate(userReservationDto.getEndDate())
                        .status(ReservationStatus.valueOf(userReservationDto.getStatus()))
                        .build())
                .toList();
    }
}
