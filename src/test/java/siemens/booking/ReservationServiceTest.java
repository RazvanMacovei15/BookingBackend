//package siemens.booking.repositories;
//
//import lombok.AllArgsConstructor;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import siemens.booking.TestUtils;
//
//import siemens.booking.dto.requests.SaveReservationRequest;
//import siemens.booking.entity.Hotel;
//import siemens.booking.entity.Reservation;
//import siemens.booking.entity.Room;
//import siemens.booking.entity.User;
//import siemens.booking.repository.HotelRepository;
//import siemens.booking.repository.RoomRepository;
//import siemens.booking.repository.UserRepository;
//import siemens.booking.service.ReservationService;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@AllArgsConstructor
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class ReservationServiceTest {
//    private final UserRepository userRepository;
//    private final HotelRepository hotelRepository;
//    private final RoomRepository roomRepository;
//    private final ReservationService reservationService;
//
//    @Test
//    public void customQuery() {
//        Hotel hotel = TestUtils.createTestHotelA();
//
//        Room room = TestUtils.createTestRoomA(hotel);
//        hotelRepository.save(hotel);
//        User user = TestUtils.createTestUser();
//        userRepository.save(user);
//        Reservation reservation = TestUtils.createTestReservation(room);
//        SaveReservationRequest request = SaveReservationRequest.builder()
//                .id(reservation.getId())
//                .startDate(reservation.getStartDate())
//                .endDate(reservation.getEndDate())
//                .user(user)
//                .room(room)
//                .build();
//        reservationService.save(request);
//        int response = reservationService.customQuery(room);
//        System.out.println(response);
//        assertThat(response).isEqualTo(1);
//    }
//}