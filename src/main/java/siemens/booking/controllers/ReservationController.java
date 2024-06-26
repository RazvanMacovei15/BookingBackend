package siemens.booking.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import siemens.booking.dto.ReservationRequest;
import siemens.booking.entity.Reservation;
import siemens.booking.model.UserReservation;
import siemens.booking.services.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public List<UserReservation> getUserReservations(@RequestParam Long userId){
        return reservationService.getUserReservations(userId);
    }
    @PostMapping
    public Long reserveRoom(@RequestBody ReservationRequest reservationRequest) {
        // create reservation
        Reservation savedReservation = reservationService.reserveRoom(reservationRequest);
        return savedReservation.getId();
    }

    @PutMapping(path = "/{id}/cancelations")
    public void cancelReservation(@PathVariable Long id){
        reservationService.cancelReservation(id);
    }
}