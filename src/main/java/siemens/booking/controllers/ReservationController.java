package siemens.booking.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import siemens.booking.dto.requests.ReservationDto;
import siemens.booking.entity.Reservation;
import siemens.booking.mappers.Mapper;
import siemens.booking.services.ReservationService;

@RestController
@AllArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    private Mapper<Reservation, ReservationDto> reservationMapper;

    @PostMapping(path = "/reservation")
    public ReservationDto createReservation(@RequestBody ReservationDto reservationDto) {
        // create reservation
        Reservation reservation = reservationMapper.mapFrom(reservationDto);
        Reservation savedReservation = reservationService.save(reservation);
        return reservationMapper.mapTo(savedReservation);
    }
}
