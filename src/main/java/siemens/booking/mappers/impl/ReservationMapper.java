package siemens.booking.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import siemens.booking.dto.requests.ReservationDto;
import siemens.booking.entity.Reservation;
import siemens.booking.mappers.Mapper;

@Component
public class ReservationMapper implements Mapper<Reservation, ReservationDto> {
    private ModelMapper modelMapper;

    public ReservationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ReservationDto mapTo(Reservation reservation) {
        return modelMapper.map(reservation, ReservationDto.class);
    }

    @Override
    public Reservation mapFrom(ReservationDto reservationDto) {
        return modelMapper.map(reservationDto, Reservation.class);
    }
}
