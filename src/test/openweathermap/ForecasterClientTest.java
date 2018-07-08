package test.openweathermap;

import openweathermap.ForecasterClient;
import org.junit.Test;

import static org.junit.Assert.*;

public class ForecasterClientTest {

    @Test
    public void searchCityForecast() {
        ForecasterClient client = new ForecasterClient("20a37921e6b890f1c14a60c19afdf8ec");
        try {
            assertNotNull(client.searchCityForecast("ala"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}