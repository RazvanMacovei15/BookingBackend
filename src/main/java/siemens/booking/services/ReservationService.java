package siemens.booking.services;

import siemens.booking.dto.ReservationRequest;
import siemens.booking.entity.Reservation;
import siemens.booking.model.UserReservation;

import java.util.List;

public interface ReservationService {
    Reservation reserveRoom(ReservationRequest reservationRequest);

    List<UserReservation> getUserReservations(Long userId);
}
