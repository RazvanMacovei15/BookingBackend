package siemens.booking.repository;


import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.json.*;
import org.springframework.stereotype.Component;
import siemens.booking.entity.Hotel;
import siemens.booking.entity.Room;
import siemens.booking.model.RoomType;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer {
    private static final String JSON_DATABASE = "src/main/resources/static/hotels.json";

    private final HotelRepository hotelRepo;

    private final RoomRepository roomRepo;

    @Transactional
    public void initialize() {
        String content = readFile();
        JSONArray jsonObject = new JSONArray(content);
        List<Hotel> hotels = new LinkedList<>();
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
                rooms.add(Room.builder()
                        .number(roomNumber)
                        .type(RoomType.valueOf(roomType).getValue())
                        .price(price)
                        .isAvailable(isAvailable)
                        .hotel(hotel)
                        .build());
            }
            hotel.setRooms(rooms);
        }
        hotelRepo.saveAll(hotels);
//        roomRepo.saveAll(rooms);

    }

    private static String readFile() {
        try {
            return new String(Files.readAllBytes(Paths.get(JSON_DATABASE)));
        } catch (IOException e) {
            throw new RuntimeException("Could not read hotels.json", e);
        }
    }
}
