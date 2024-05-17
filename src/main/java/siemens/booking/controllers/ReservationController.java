package siemens.booking.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import siemens.booking.dto.requests.ReservationDto;
import siemens.booking.entity.Reservation;
import siemens.booking.services.ReservationServiceImpl;

@RestController
@AllArgsConstructor
public class ReservationController {

    private final ReservationServiceImpl reservationServiceImpl;
    @PostMapping(path = "/reservation")
    public void createReservation(@RequestBody ReservationDto reservationDto) {
        // create reservation
        return reservationServiceImpl.save(reservation);
    }
}
