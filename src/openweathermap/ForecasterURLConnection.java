package openweathermap;

import org.json.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Making a connection to openweathermap api, request by id
 * Retrieve forecast result 5 day/3 hour on JSONObject
 */
public class ForecasterURLConnection {
    private final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast?APPID=";
    private final String QUERY_CODE = "&q=";
    private String url;

    public ForecasterURLConnection(String apikey) {
        this.url = BASE_URL + apikey + QUERY_CODE;
    }

    /**
     * Read and return response on JSONObject type
     */
    private JSONObject readResponse(HttpURLConnection connection) throws IOException {
        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                                                        connection.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
        }
        return new JSONObject(response.toString());
    }

    /**
     * Send request to openweathermap API
     * return response on JSONObject format
     */
    public JSONObject makeRequest(String cityname) throws ForecasterException {
        try {
            URL urladdress = new URL(this.url + cityname);
            HttpURLConnection connection = (HttpURLConnection) urladdress.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("City Not Found");
            }

            JSONObject response = readResponse(connection);

            connection.disconnect();
            return response;
        } catch (RuntimeException e) {
            throw new ForecasterException(e.getMessage());
        } catch (IOException e) {
            throw new ForecasterException("Error I/O");
        }
    }
}