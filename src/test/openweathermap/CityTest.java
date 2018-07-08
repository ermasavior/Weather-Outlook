package test.openweathermap;

import org.json.JSONObject;
import openweathermap.City;

import static org.junit.Assert.*;

public class CityTest {
    City city = new City(new JSONObject("{\"id\":6940463,\"name\":\"Altstadt\",\"coord\":{\"lat\":48.137,\"lon\":11.5752},\"country\":\"DE\"}"));

    @org.junit.Test
    public void getName() {
        assertNotNull(city.getName());
        assertEquals(city.getName(), "Altstadt");
    }

    @org.junit.Test
    public void getCountry() {
        assertNotNull(city.getCountry());
        assertEquals(city.getCountry(), "DE");
    }

    @org.junit.Test
    public void getLatitude() {
        //assertNotNull(city.getLatitude());
        assertEquals(city.getLatitude(), 48.137, 0.5);
    }

    @org.junit.Test
    public void getLongitude() {
        //assertNotNull(city.getLongitude());
        assertEquals("Yes", city.getLongitude(), 11.5, 0.5);
    }
}