package siemens.booking.json;


import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;


import org.json.*;
import org.springframework.stereotype.Service;
import siemens.booking.domain.Hotel;
import siemens.booking.domain.Room;
import siemens.booking.enums.RoomType;
import siemens.booking.service.HotelService;
import siemens.booking.service.RoomService;

@Service
public class JsonService {
    private HotelService hotelService;
    private RoomService roomService;

    public JsonService() {
        this.hotelService = new HotelService();
        this.roomService = new RoomService();
    }

    private static final String JSON_DATABASE = "src/main/resources/static/hotels.json";
    public void readJsonFile() {

        try {
            String content = new String(Files.readAllBytes(Paths.get(JSON_DATABASE)));
            JSONArray jsonObject = new JSONArray(content);
            for (int i = 0; i < jsonObject.length(); i++) {
                JSONObject hotelJson = jsonObject.getJSONObject(i);
                long id = hotelJson.getLong("id");
                String name = hotelJson.getString("name");
                BigDecimal latitude  = BigDecimal.valueOf(hotelJson.getDouble("latitude"));
                BigDecimal longitude = BigDecimal.valueOf(hotelJson.getDouble("longitude"));
                Hotel hotel = Hotel.builder()
                        .id(id)
                        .latitude(latitude)
                        .longitude(longitude)
                        .name(name)
                        .build();
                hotelService.saveHotel(hotel);
                JSONArray roomsArray = hotelJson.getJSONArray("rooms");
                for(int j = 0; j < roomsArray.length(); j++){
                    JSONObject roomJson = roomsArray.getJSONObject(j);
                    int roomNumber = roomJson.getInt("roomNumber");
                    int roomType = roomJson.getInt("type");
                    BigDecimal price = BigDecimal.valueOf(roomJson.getDouble("price"));
                    boolean isAvailable = roomJson.getBoolean("isAvailable");
                    Room room = Room.builder()
                                    .roomNumber(roomNumber)
                                            .roomType(RoomType.valueOf(roomType))
                                                    .price(price)
                                                            .isAvailable(isAvailable)
                                                                    .build();
                    roomService.saveRoom(room);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    //method to read from a json file and return a list of hotels


    public static void main(String[] args) {
        JsonService jsonService = new JsonService();
        jsonService.readJsonFile();
    }
}
