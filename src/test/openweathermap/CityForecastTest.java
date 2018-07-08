package test.openweathermap;

import openweathermap.City;
import openweathermap.CityForecast;
import openweathermap.HourlyForecast;
import org.json.JSONObject;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.Assert.*;

public class CityForecastTest {
    CityForecast forecast;

    public CityForecastTest() {
        try {
            forecast = new CityForecast(readJSONFile("cityforecast.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCity() {
        City city = new City(new JSONObject("{\"id\":6940463,\"name\":\"Altstadt\",\"coord\":{\"lat\":48.137,\"lon\":11.5752},\"country\":\"DE\"}"));

        assertEquals(forecast.getCity().getLatitude(), city.getLatitude(), 0.001);
        assertEquals(forecast.getCity().getLongitude(), city.getLongitude(), 0.001);
    }

    @Test
    public void getHourlyForecastList() {
        assertNotNull(forecast.getHourlyForecastList());
    }

    @Test
    public void addHourlyForecast() {
        try {
            HourlyForecast hourlyforecast = new HourlyForecast(readJSONFile("hourlyforecast.txt"));
            forecast.addHourlyForecast(hourlyforecast);
            assertTrue("Passed", forecast.getHourlyForecastList().contains(forecast));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JSONObject readJSONFile(String filename) {
        String str = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("..\\Weather-Outlook\\src\\test\\openweathermap\\" + filename));

            String text;
            while ((text = br.readLine()) != null)
                str += text;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONObject(str);
    }
}