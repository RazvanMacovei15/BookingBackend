package siemens.booking;

import siemens.booking.entity.Hotel;
import siemens.booking.entity.Reservation;
import siemens.booking.entity.Room;
import siemens.booking.entity.User;
import siemens.booking.model.RoomType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestUtils {
    public static Hotel createTestHotelA() {
        return Hotel.builder()
                .id(1L)
                .name("Ramada")
                .latitude(new BigDecimal("67.45674674"))
                .longitude(new BigDecimal("67.45674674"))
                .build();
    }

    public static Hotel createTestHotelB() {
        return Hotel.builder()
                .id(2L)
                .name("Hilton")
                .latitude(new BigDecimal("67.45674674"))
                .longitude(new BigDecimal("67.45674674"))
                .build();
    }

    public static  Hotel createTestHotelC() {
        return Hotel.builder()
                .id(3L)
                .name("Marriot")
                .latitude(new BigDecimal("67.45674674"))
                .longitude(new BigDecimal("67.45674674"))
                .build();
    }

    public static Room createTestRoomA(Hotel hotel){
        return Room.builder()
                .id(1L)
                .number(101)
                .type(RoomType.SINGLE.getValue())
                .price(new BigDecimal("100.00"))
                .isAvailable(true)
                .hotel(hotel)
                .build();
    }

    public static Room createTestRoomB(Hotel hotel){
        return Room.builder()
                .id(2L)
                .number(102)
                .type(RoomType.DOUBLE.getValue())
                .price(new BigDecimal("200.00"))
                .isAvailable(true)
                .hotel(hotel)
                .build();
    }

    public static Room createTestRoomC(Hotel hotel){
        return Room.builder()
                .id(3L)
                .number(103)
                .type(RoomType.SUITE.getValue())
                .price(new BigDecimal("300.00"))
                .isAvailable(true)
                .hotel(hotel)
                .build();
    }

    public static Reservation createTestReservationA(Room room,User user){
        return Reservation.builder()
                .startDate(LocalDate.parse("2021-10-01"))
                .endDate(LocalDate.parse("2021-10-10"))
                .room(room)
                .user(user)
                .build();
    }

    public static Reservation createTestReservationB(Room room,User user){
        return Reservation.builder()
                .startDate(LocalDate.parse("2021-10-11"))
                .endDate(LocalDate.parse("2021-10-20"))
                .room(room)
                .user(user)
                .build();
    }

    public static Reservation createTestReservationC(Room room,User user){
        return Reservation.builder()
                .startDate(LocalDate.parse("2021-10-21"))
                .endDate(LocalDate.parse("2021-10-30"))
                .room(room)
                .user(user)
                .build();
    }

    public static User createTestUserA() {
        return User.builder()
                .fullName("John Doe")
                .email("@idiots.com")
                .longitude(new BigDecimal("67.45674674"))
                .latitude(new BigDecimal("67.45674674"))
                .build();
    }
    
    public static User createTestUserB() {
        return User.builder()
                .fullName("Jane Doe")
                .email("@idiots.com")
                .longitude(new BigDecimal("67.45674674"))
                .latitude(new BigDecimal("67.45674674"))
                .build();
    }

    public static User createTestUserC() {
        return User.builder()
                .fullName("John Smith")
                .email("@idiots.com")
                .longitude(new BigDecimal("67.45674674"))
                .latitude(new BigDecimal("67.45674674"))
                .build();
    }
}
