package siemens.booking;

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
import siemens.booking.repository.DatabaseInitializer;
import siemens.booking.repository.LocationRepository;
import siemens.booking.repository.UserRepository;
import siemens.booking.services.HotelService;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BookingApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookingApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(DatabaseInitializer databaseInitializer, HotelService hotelService, UserRepository userRepository, LocationRepository locationRepository) {
        return args -> {
            databaseInitializer.initializeHotelsAndRooms();
            System.out.println("EXECUTING : command line runner");

            Scanner scanner = new Scanner(System.in);
            String inputData;
            BigDecimal inputBigDecimal = null;
            while (true) {
                System.out.println("-----WELCOME TO THE BOOKING APPLICATION-----");
                System.out.println(StaticStrings.MAIN_MENU);
                inputData = scanner.nextLine();
                switch (inputData) {
                    case "1":
                        System.out.println(StaticStrings.RADIUS_MENU);
                        int input = scanner.nextInt();
                        try {
                            inputBigDecimal = new BigDecimal(input);
                            System.out.println(StaticStrings.AFTER_RADIUS_INPUT);
                            BigDecimal latitude = locationRepository.findById(1L).orElseThrow().getLatitude();
                            BigDecimal longitude = locationRepository.findById(1L).orElseThrow().getLongitude();
                            String json = RequestService.createGetRequest(ApiEndpoints.generateHotelSearchByRadius(latitude, longitude, input));
                            List<HotelDto> hotels = new JsonParser(json).getHotelsInRadiusParser();
                            for (HotelDto hotel : hotels) {
                                System.out.println(hotel.toString());
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input '" + input + "'. Please enter a valid number.");
                        }
                        System.out.println(StaticStrings.HOTEL_SELECTION);
                        input = scanner.nextInt();
                        int hotelId = input;
                        String roomJson = RequestService.createGetRequest(ApiEndpoints.roomSearch((long) hotelId));
                        List<RoomDto> rooms = new JsonParser(roomJson).roomsParser();
                        for (RoomDto room : rooms) {
                            System.out.println(room.toString());
                        }
                        System.out.println(StaticStrings.ROOM_SELECT_PROMPT);
                        String startDate = scanner.next();
                        System.out.println(StaticStrings.ROOM_SELECT_PROMPT_END);
                        String endDate = scanner.next();
                        String jsonRoomAvailabilityInTimePeriod = RequestService.createGetRequest(ApiEndpoints.roomSearchByDates((long) hotelId, startDate, endDate));
                        List<RoomDto> availableRooms = new JsonParser(jsonRoomAvailabilityInTimePeriod).roomsParser();
                        if(availableRooms.isEmpty()) {
                            System.out.println("No rooms available in the selected time period.");
                            break;
                        }
                        System.out.println("The following rooms are available in the selected time period: ");
                        for (RoomDto room : availableRooms) {
                            System.out.println(room.toString());
                        }
                        //select multiple rooms
                        System.out.println("Do you want to book a room? (y/n)");
                        String answer = scanner.next();
                        if(answer.equals("y")) {
                            System.out.println("Enter the number of rooms you want to book: ");
                            int numberOfRooms = scanner.nextInt();
                            for (int i = 0; i < numberOfRooms; i++) {
                                System.out.println("Enter the id of the room you want to book: ");
                                Long roomId = scanner.nextLong();
                                int userId = 1;
                                String reservationId =RequestService.createPostRequest(ApiEndpoints.reservation(), """
                                        {
                                        "startDate": "%s",
                                        "endDate": "%s",
                                        "roomId": %d,
                                        "userId": %d
                                        }
                                        """.formatted(startDate, endDate, roomId, userId));
                                if(reservationId != null) {
                                    System.out.println("Reservation with id " + reservationId + " was created successfully.");
                                } else {
                                    System.out.println("Reservation was not created.");
                                }
                            }
                        }else{
                            System.out.println("returning to main menu");
                        }
                        break;
                    case "2":
                        int userId = 1;
                        String userReservations = RequestService.createGetRequest("http://localhost:8010/reservations?userId="+userId);
                        JsonParser jsonParser = new JsonParser(userReservations);
                        jsonParser.userReservations().forEach(System.out::println);
                        System.out.println("Do you want to cancel a reservation? (y/n)");
                        String cancel = scanner.next();
                        if(cancel.equals("y")) {
                            System.out.println("Enter the id of the reservation you want to cancel: ");
                            Long reservationId = scanner.nextLong();
                            boolean cancelReservation = RequestService.cancelReservation("http://localhost:8010/reservations/" + reservationId+"/cancelations");
                            if (cancelReservation) {
                                System.out.println("Reservation with id " + reservationId + " was canceled successfully.");
                            } else {
                                System.out.println("Reservation was not canceled.");
                            }
                        }
                        break;
                    case "0":
                        System.out.println("Exiting the application");
                        System.exit(0);
                    default:
                        System.out.println("Unknown command");
                }

                // Clear console after each user input
                try {
                    if (System.getProperty("os.name").contains("Windows")) {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } else {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    }
                } catch (IOException | InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
    }
}
