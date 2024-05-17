package siemens.booking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import siemens.booking.json.JsonService;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = "siemens.booking.json")
public class BookingApplication {

    public static void main(String[] args) {

        SpringApplication.run(BookingApplication.class, args);

    }
    @Bean
    CommandLineRunner initDatabase(JsonService jsonService) {
        return args -> {
            jsonService.readJsonFile();
        };
    }

}
