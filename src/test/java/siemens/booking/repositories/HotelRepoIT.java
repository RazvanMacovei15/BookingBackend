package siemens.booking.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import siemens.booking.TestUtils;
import siemens.booking.domain.Hotel;
import siemens.booking.repos.HotelRepo;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class HotelRepoIT {
    private HotelRepo hotelRepo;


    @Autowired
    public HotelRepoIT(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    @Test
    public void testThatHotelCanBeCreatedAndRecalled(){
        Hotel hotel = TestUtils.createTestHotelA();
        hotelRepo.save(hotel);
        Optional<Hotel> hotelOptional = hotelRepo.findById(hotel.getId());
        assert hotelOptional.isPresent();
        assert (hotelOptional.get()).equals(hotel);
    }

    @Test
    public void testThatMultipleHotelsCanBeCreatedAndRecalled(){
        Hotel hotelA = TestUtils.createTestHotelA();
        Hotel hotelB = TestUtils.createTestHotelB();
        Hotel hotelC = TestUtils.createTestHotelC();

        hotelRepo.save(hotelA);
        hotelRepo.save(hotelB);
        hotelRepo.save(hotelC);

        Iterable<Hotel> hotels = hotelRepo.findAll();
        assertThat(hotels)
                .hasSize(3)
                .containsExactly(hotelA, hotelB, hotelC);
    }

    @Test
    public void testThatHotelCanBeDeleted(){
        Hotel hotel = TestUtils.createTestHotelA();
        hotelRepo.save(hotel);
        hotelRepo.delete(hotel);
        List<Hotel> hotels = hotelRepo.findAll();
        assertThat(hotels).isEmpty();
    }

    @Test
    public void testThatHotelCanBeUpdated() {
        Hotel hotel = TestUtils.createTestHotelA();
        hotelRepo.save(hotel);
        hotel.setName("HiltonUPDATED");
        hotelRepo.save(hotel);
        Optional<Hotel> hotelOptional = hotelRepo.findById(hotel.getId());
        assertThat(hotelOptional).isPresent();
        assertThat(hotelOptional.get()).isEqualTo(hotel);
    }






}
