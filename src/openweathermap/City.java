package openweathermap;

import org.json.*;

public class City {
    private String name;
    private String country;

    public City(JSONObject cityObj) {
        this.name = cityObj.getString("name");
        this.country = cityObj.getString("country");
    }
    
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}