package siemens.booking.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import siemens.booking.TestUtils;
import siemens.booking.domain.Hotel;
import siemens.booking.domain.Room;
import siemens.booking.enums.RoomType;
import siemens.booking.repos.RoomRepo;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RoomRepoIT {
    private RoomRepo roomRepo;

    @Autowired
    public RoomRepoIT(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Test
    public void testThatRoomCanBeCreatedAndRecalled(){
        Hotel hotel = TestUtils.createTestHotelA();
        Room room = TestUtils.createTestRoomA(hotel);
        roomRepo.save(room);
        Optional<Room> roomOptional = roomRepo.findById(room.getId());
        assert roomOptional.isPresent();
        assert (roomOptional.get()).equals(room);
    }

    @Test
    public void testThatMultipleRoomsCanBeCreatedAndRecalled(){
        Hotel hotel = TestUtils.createTestHotelA();
        Room roomA = TestUtils.createTestRoomA(hotel);
        Room roomB = TestUtils.createTestRoomB(hotel);
        Room roomC = TestUtils.createTestRoomC(hotel);

        roomRepo.save(roomA);
        roomRepo.save(roomB);
        roomRepo.save(roomC);

        Iterable<Room> rooms = roomRepo.findAll();
        assertThat(rooms)
                .hasSize(3)
                .containsExactly(roomA, roomB, roomC);
    }

    @Test
    public void testThatRoomCanBeDeleted(){
        Hotel hotel = TestUtils.createTestHotelA();
        Room room = TestUtils.createTestRoomA(hotel);
        roomRepo.save(room);
        roomRepo.deleteById(room.getId());
        Iterable<Room> rooms = roomRepo.findAll();
        assertThat(rooms).isEmpty();
    }

    @Test
    public void testThatRoomCanBeUpdated() {
        Hotel hotel = TestUtils.createTestHotelA();
        Room room = TestUtils.createTestRoomA(hotel);
        roomRepo.save(room);
        room.setRoomNumber(102);
        room.setRoomType(RoomType.DOUBLE);
        room.setPrice(new BigDecimal("200.00"));
        room.setAvailable(true);
        roomRepo.save(room);
        Optional<Room> roomOptional = roomRepo.findById(room.getId());
        assert roomOptional.isPresent();
        assert (roomOptional.get()).equals(room);
    }

}
