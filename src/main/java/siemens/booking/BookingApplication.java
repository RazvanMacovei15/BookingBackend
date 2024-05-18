package siemens.booking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import siemens.booking.consoleapllication.ApiEndpoints;
import siemens.booking.consoleapllication.JsonParser;
import siemens.booking.consoleapllication.RequestService;
import siemens.booking.consoleapllication.StaticStrings;
import siemens.booking.dto.HotelDto;
import siemens.booking.dto.RoomDto;
import siemens.booking.entity.Hotel;
import siemens.booking.entity.Location;
import siemens.booking.repository.DatabaseInitializer;
import siemens.booking.repository.HotelRepository;
import siemens.booking.repository.LocationRepository;
import siemens.booking.repository.UserRepository;
import siemens.booking.services.HotelService;
import siemens.booking.services.impl.HotelServiceImpl;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BookingApplication {



    private static Logger LOG = LoggerFactory.getLogger(BookingApplication.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(BookingApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }


    @Bean
    CommandLineRunner commandLineRunner(DatabaseInitializer databaseInitializer, HotelService hotelService, UserRepository userRepository, LocationRepository locationRepository) {
        return args -> {

            databaseInitializer.initializeHotelsAndRooms();
//            LOG.info("EXECUTING : command line runner");
//
//            Scanner scanner = new Scanner(System.in);
//            String inputData;
//            BigDecimal inputBigDecimal = null;
//
//
//            while (true) {
//                LOG.info("-----WELCOME TO THE BOOKING APPLICATION-----");
//                LOG.info(StaticStrings.MAIN_MENU);
//                inputData = scanner.nextLine();
//                switch (inputData) {
//                    case "1":
//                        LOG.info(StaticStrings.RADIUS_MENU);
//                        int input = scanner.nextInt();
//                        try {
//                            inputBigDecimal = new BigDecimal(input);
//                            LOG.info(StaticStrings.AFTER_RADIUS_INPUT);
//                            BigDecimal latitude = locationRepository.findById(1L).orElseThrow().getLatitude();
//                            BigDecimal longitude = locationRepository.findById(1L).orElseThrow().getLongitude();
//                            String json = RequestService.createGetRequest(ApiEndpoints.generateHotelSearchByRadius(latitude, longitude, input));
//                            List<HotelDto> hotels = new JsonParser(json).getHotelsInRadiusParser();
//                            for (HotelDto hotel : hotels) {
//                                LOG.info(hotel.toString());
//                            }
//                        } catch (NumberFormatException e) {
//                            LOG.error("Invalid input '" + input + "'. Please enter a valid number.");
//                        }
//                        LOG.info(StaticStrings.HOTEL_SELECTION);
//                        input = scanner.nextInt();
//                        int hotelId = input;
//                        String roomJson = RequestService.createGetRequest(ApiEndpoints.roomSearch((long) hotelId));
//                        System.out.println(roomJson);
////                        List<RoomDto> rooms = new JsonParser(roomJson).roomsParser();
////                        for (RoomDto room : rooms) {
////                            LOG.info(room.toString());
////                        }
//                        LOG.info(StaticStrings.ROOM_SELECTION);
//                        input = scanner.nextInt();
//                        LOG.info("You have selected room with id: " + input);
//                        break;
//                    case "0":
//                        LOG.info("Exiting the application");
//                        System.exit(0);
//                    default:
//                        LOG.info("Unknown command");
//                }
//
//                // Clear console after each user input
//                try {
//                    if (System.getProperty("os.name").contains("Windows")) {
//                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//                    } else {
//                        System.out.print("\033[H\033[2J");
//                        System.out.flush();
//                    }
//                } catch (IOException | InterruptedException ex) {
//                    ex.printStackTrace();
//                }
//            }
        };
    }
}
