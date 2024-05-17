package siemens.booking.repository;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import siemens.booking.entity.Hotel;
import siemens.booking.entity.Reservation;
import siemens.booking.entity.Room;
import siemens.booking.entity.User;
import siemens.booking.model.RoomType;
import siemens.booking.rapidapi.UserLocation;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer {
    private static final String JSON_DATABASE_HOTELS_ROOMS = "src/main/resources/static/hotels.json";
    private static final String JSON_DATABASE_DEFAULT_USER = "src/main/resources/static/createUserJSON.json";
    private static final String RESERVATION_A = "src/main/resources/static/reservationA.json";
    private static final String RESERVATION_B = "src/main/resources/static/reservationB.json";
    private static final String RESERVATION_C = "src/main/resources/static/reservationC.json";

    private final HotelRepository hotelRepo;

    private final UserRepository userRepository;

    private final ReservationRepository reservationRepository;

    private final RoomRepository roomRepository;




    @Transactional
    public void initializeHotelsAndRooms() {
        String content = readHotelsAndRoomsFile();
        JSONArray jsonObject = new JSONArray(content);
        List<Hotel> hotels = new LinkedList<>();
        for (int i = 0; i < jsonObject.length(); i++) {
            JSONObject hotelJson = jsonObject.getJSONObject(i);

            String name = hotelJson.getString("name");
            BigDecimal latitude = BigDecimal.valueOf(hotelJson.getDouble("latitude"));
            BigDecimal longitude = BigDecimal.valueOf(hotelJson.getDouble("longitude"));
            Hotel hotel = Hotel.builder()
                    .latitude(latitude)
                    .longitude(longitude)
                    .name(name)
                    .build();
            hotels.add(hotel);
            JSONArray roomsArray = hotelJson.getJSONArray("rooms");
            List<Room> rooms = new LinkedList<>();
            for (int j = 0; j < roomsArray.length(); j++) {
                JSONObject roomJson = roomsArray.getJSONObject(j);
                int roomNumber = roomJson.getInt("roomNumber");
                int roomType = roomJson.getInt("type");
                BigDecimal price = BigDecimal.valueOf(roomJson.getDouble("price"));
                boolean isAvailable = roomJson.getBoolean("isAvailable");
                Room room = Room.builder()
                        .number(roomNumber)
                        .type(RoomType.valueOf(roomType).getValue())
                        .price(price)
                        .isAvailable(isAvailable)
                        .hotel(hotel)
                        .build();
                rooms.add(room);
            }
            hotel.setRooms(rooms);
        }
        hotelRepo.saveAll(hotels);
        userRepository.save(initializeDefaultUser());
    }

    private static String readHotelsAndRoomsFile() {
        try {
            return new String(Files.readAllBytes(Paths.get(JSON_DATABASE_HOTELS_ROOMS)));
        } catch (IOException e) {
            throw new RuntimeException("Could not read hotels.json", e);
        }
    }
    private static String readFile(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException("Could not read hotels.json", e);
        }
    }

    public User initializeDefaultUser(){
        String content = readFile(JSON_DATABASE_DEFAULT_USER);
        JSONObject jsonObject = new JSONObject(content);
        String fullName = jsonObject.getString("fullName");
        String email = jsonObject.getString("email");
        BigDecimal latitude = new BigDecimal(jsonObject.getDouble("latitude"));
        BigDecimal longitude = new BigDecimal(jsonObject.getDouble("longitude"));
        return User.builder()
                .fullName(fullName)
                .email(email)
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }

    public void initializeReservationA(){
        String content = readFile(RESERVATION_A);
        JSONObject jsonObject = new JSONObject(content);
        saveReservation(jsonObject);
    }
    public void initializeReservationC(){
        String content = readFile(RESERVATION_C);
        JSONObject jsonObject = new JSONObject(content);
        saveReservation(jsonObject);
    }
    public void initializeReservationB(){
        String content = readFile(RESERVATION_B);
        JSONObject jsonObject = new JSONObject(content);
        saveReservation(jsonObject);
    }

    private void saveReservation(JSONObject jsonObject) {
        LocalDate startDate = LocalDate.parse(jsonObject.getString("startDate"));
        LocalDate endDate = LocalDate.parse(jsonObject.getString("endDate"));
        Long userId = jsonObject.getLong("userId");
        Long roomId = jsonObject.getLong("roomId");
        reservationRepository.save(Reservation.builder()
                .startDate(startDate)
                .endDate(endDate)
                .user(userRepository.getReferenceById(userId))
                .room(roomRepository.getReferenceById(roomId))
                .build());
    }
}
