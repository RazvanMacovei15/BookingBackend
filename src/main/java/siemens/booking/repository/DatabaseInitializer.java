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

@Component
@RequiredArgsConstructor
public class DatabaseInitializer {
    private static final String JSON_DATABASE = "src/main/resources/static/hotels.json";

    private final HotelRepository hotelRepo;

    private final UserRepository userRepository;

    @Transactional
    public void initialize() {
        String content = readFile();
        JSONArray jsonObject = new JSONArray(content);
        List<Hotel> hotels = new LinkedList<>();
        List<Reservation> reservations = new LinkedList<>();
        User user = User.builder()
                .fullName("John Doe")
                .email("ceva")
                .latitude(BigDecimal.valueOf(0))
                .longitude(BigDecimal.valueOf(0))
                .build();
        for (int i = 0; i < jsonObject.length(); i++) {
            JSONObject hotelJson = jsonObject.getJSONObject(i);
            long id = hotelJson.getLong("id");
            String name = hotelJson.getString("name");
            BigDecimal latitude = BigDecimal.valueOf(hotelJson.getDouble("latitude"));
            BigDecimal longitude = BigDecimal.valueOf(hotelJson.getDouble("longitude"));
            Hotel hotel = Hotel.builder()
                    .id(id)
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

                Reservation reservation = Reservation.builder()
                        .startDate(LocalDate.parse("2021-10-10"))
                        .endDate(LocalDate.parse("2021-10-20"))
                        .user(user)
                        .room(room)
                        .build();
                reservations.add(reservation);
            }
            hotel.setRooms(rooms);
        }
        user.setReservations(reservations);
        userRepository.save(user);
        hotelRepo.saveAll(hotels);

    }

    private static String readFile() {
        try {
            return new String(Files.readAllBytes(Paths.get(JSON_DATABASE)));
        } catch (IOException e) {
            throw new RuntimeException("Could not read hotels.json", e);
        }
    }
}
