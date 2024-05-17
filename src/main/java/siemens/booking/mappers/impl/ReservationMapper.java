package siemens.booking.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import siemens.booking.dto.ReservationRequest;
import siemens.booking.entity.Reservation;
import siemens.booking.mappers.Mapper;

@Component
public class ReservationMapper implements Mapper<Reservation, ReservationRequest> {
    private ModelMapper modelMapper;

    public ReservationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ReservationRequest mapTo(Reservation reservation) {
        return modelMapper.map(reservation, ReservationRequest.class);
    }

    @Override
    public Reservation mapFrom(ReservationRequest reservationRequest) {
        return modelMapper.map(reservationRequest, Reservation.class);
    }
}
