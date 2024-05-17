package siemens.booking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import siemens.booking.repository.DatabaseInitializer;

@SpringBootApplication
public class BookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingApplication.class, args);
    }
    @Bean
    CommandLineRunner initDatabase(DatabaseInitializer jsonService) {
        return args -> {
            jsonService.initializeHotelsAndRooms();
        };
    }

}
