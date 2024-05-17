package siemens.booking.services;

import siemens.booking.dto.requests.SaveReservationRequest;

public interface ReservationService {
    long save(SaveReservationRequest request);
}
