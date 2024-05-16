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

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class HotelRepoIntegrationTests {
    private final HotelRepo hotelRepo;

    @Autowired
    public HotelRepoIntegrationTests(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    @Test
    public void testThatHotelCanBeCreatedAndRecalled(){
        Hotel hotel = TestUtils.createHotel();
        hotelRepo.save(hotel);
        Optional<Hotel> result = hotelRepo.findById(hotel.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(hotel);
    }

}
