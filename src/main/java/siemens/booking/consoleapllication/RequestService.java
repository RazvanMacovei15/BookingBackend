package siemens.booking.consoleapllication;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestService {
    public static String createGetRequest(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create(url))
                .GET()
                .build();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                System.err.println("HTTP Request failed with status code: " + response.statusCode());
            }
        } catch (java.io.IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return response.body();
    }

    public static String createPostRequest(String url, String body) {
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                System.err.println("HTTP Request failed with status code: " + response.statusCode());
            }
        } catch (java.io.IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return response.body();
    }
}
