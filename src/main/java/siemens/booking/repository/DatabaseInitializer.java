package siemens.booking.repository;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import siemens.booking.entity.*;
import siemens.booking.model.RoomType;
import siemens.booking.rapidapi.LocationApi;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer {
    private static final String JSON_DATABASE_HOTELS_ROOMS = "src/main/resources/static/hotels.json";
    private static final String JSON_DATABASE_DEFAULT_USER = "src/main/resources/static/createUserJSON.json";

    private final HotelRepository hotelRepo;

    private final UserRepository userRepository;

    private final LocationRepository locationRepository;

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
                    .checkInTime(LocalTime.of(14,0))
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
        locationRepository.save(getUserCurrentLocation());
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
        return User.builder()
                .fullName(fullName)
                .email(email)
                .build();
    }

    public Location getUserCurrentLocation(){
        LocationApi location = new LocationApi();
        location.getUserCurrentLocation();
        return Location.builder()
                .longitude(location.getLongitude())
                .latitude(location.getLatitude())
                .build();
    }

    public static void main(String[] args) {

    }
}
