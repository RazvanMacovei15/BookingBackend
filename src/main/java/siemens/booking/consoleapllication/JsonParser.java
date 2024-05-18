package siemens.booking.consoleapllication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import siemens.booking.dto.HotelDto;
import siemens.booking.dto.RoomDto;
import siemens.booking.model.ReservationStatus;
import siemens.booking.model.UserReservation;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonParser {
    private String json;

    public JsonParser(String json) {
        this.json = json;
    }

    public List<HotelDto> getHotelsInRadiusParser() {
        List<HotelDto> hotels = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                HotelDto hotel = HotelDto.builder()
                        .id(jsonObject.getLong("id"))
                        .name(jsonObject.getString("name"))
                        .checkInTime(LocalTime.parse(jsonObject.getString("checkInTime")))
                        .build();
                hotels.add(hotel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return hotels;
    }

    public List<RoomDto> roomsParser () {
        List<RoomDto> rooms = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                RoomDto room = RoomDto.builder()
                        .id(jsonObject.getLong("id"))
                        .number(jsonObject.getInt("number"))
                        .price(BigDecimal.valueOf(jsonObject.getDouble("price")))
                        .build();
                rooms.add(room);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return rooms;
    }

    public List<UserReservation> userReservations () {
        List<UserReservation> rooms = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                UserReservation userReservation = UserReservation.builder()
                        .id(jsonObject.getLong("id"))
                        .hotelName(jsonObject.getString("hotelName"))
                        .roomNumber(jsonObject.getInt("roomNumber"))
                        .price(BigDecimal.valueOf(jsonObject.getDouble("price")))
                        .startDate(LocalDate.parse(jsonObject.getString("startDate")))
                        .endDate(LocalDate.parse(jsonObject.getString("endDate")))
                        .status(jsonObject.getString("status").equals("ACTIVE")  ? ReservationStatus.ACTIVE : ReservationStatus.CANCELLED)
                        .build();
                rooms.add(userReservation);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return rooms;
    }


}
