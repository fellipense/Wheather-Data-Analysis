import java.io.IOException;
import java.net.URI;
import java.net.http.*;

public class Main {
    public static void main(String args[]) {
        try {
            double lat = -43.32766;
            double lon = -22.9111;
            
            String latitude = String.valueOf(lat);
            String longitude = String.valueOf(lon);
            
            System.out.println(latitude + ", " + longitude);
            
            URI uri = new URI("https://historical-forecast-api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + 
            "&start_date=2024-01-01&end_date=2024-01-31&hourly=temperature_2m&daily=temperature_2m_max,temperature_2m_min&timezone=America%2FSao_Paulo"); 
            
            HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
            
            HttpClient httpClient = HttpClient.newHttpClient();
            
            HttpResponse<String> response = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            
            System.out.println(response.body()); 
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }
}
