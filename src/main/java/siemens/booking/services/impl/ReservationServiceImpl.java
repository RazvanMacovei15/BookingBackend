package siemens.booking.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siemens.booking.dto.ReservationRequest;
import siemens.booking.entity.Reservation;
import siemens.booking.exceptions.NotFoundException;
import siemens.booking.exceptions.PreconditionFailedException;
import siemens.booking.model.ReservationStatus;
import siemens.booking.model.UserReservation;
import siemens.booking.repository.ReservationRepository;
import siemens.booking.repository.RoomRepository;
import siemens.booking.repository.UserRepository;
import siemens.booking.services.ReservationService;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    //TODO magic number change
    private static final int MAGIC_NUMBER = 2;
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
                        .id(userReservationDto.getId())
                        .hotelName(userReservationDto.getHotelName())
                        .roomNumber(userReservationDto.getRoomNumber())
                        .price(userReservationDto.getPrice())
                        .startDate(userReservationDto.getStartDate())
                        .endDate(userReservationDto.getEndDate())
                        .status(ReservationStatus.valueOf(userReservationDto.getStatus()))
                        .build())
                .toList();
    }

    @Override
    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new NotFoundException("Reservation having ID %s does not exist".formatted(reservationId)));
        LocalTime checkInTime = reservation.getRoom().getHotel().getCheckInTime();
        LocalDateTime maxCheckInDateTime = LocalDateTime.of(reservation.getStartDate(), checkInTime).minusHours(MAGIC_NUMBER);
        if(LocalDateTime.now().isAfter(maxCheckInDateTime)){
            throw new PreconditionFailedException("Can't cancel reservation within 2 hours of checkin time");
        }
        reservation.setStatus(ReservationStatus.CANCELLED.getValue());
        reservationRepository.save(reservation);
    }
}