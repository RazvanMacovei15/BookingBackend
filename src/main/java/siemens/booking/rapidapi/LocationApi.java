package siemens.booking.rapidapi;

import lombok.*;
import org.json.JSONObject;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LocationApi {

    private BigDecimal latitude;

    private BigDecimal longitude;

    private static String handleIpInfoHttpResponse() {

        HttpResponse<String> response = null;

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://ipinfo.io")).header("Authorization", "Bearer " + "2245965a2814a6") // Add the token as an "Authorization" header
                .GET().build();
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                System.err.println("HTTP Request failed with status code: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        assert response != null;
        return response.body();
    }

    public void getUserCurrentLocation(){
        String response  = handleIpInfoHttpResponse();
        String locationCoordinates = getAttribute(response);
        setCoordinates(locationCoordinates);
    }


    private void setCoordinates(String str) {
        String[] coordinates = str.split(",");
        if (coordinates.length == 2) {
            this.latitude = BigDecimal.valueOf(Double.parseDouble(coordinates[0]));
            System.out.println("Latitude: " + this.latitude);
            this.longitude =BigDecimal.valueOf(Double.parseDouble(coordinates[1]));
            System.out.println("Longitude: " + this.longitude);
        } else {
            System.out.println("You parsed the wrong attribute!");
        }
    }

    private String getAttribute(String response) {
        String attributeToReturn = null;
        try {
            JSONObject jsonObject = new JSONObject(response);
            attributeToReturn = jsonObject.getString("loc");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attributeToReturn;
    }

    public static void main(String[] args) {
        handleIpInfoHttpResponse();
    }
}
