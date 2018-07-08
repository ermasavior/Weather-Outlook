package openweathermap;

import org.json.*;

public class City {
    private String name;
    private String country;
    private double latitude;
    private double longitude;

    public City(JSONObject cityObj) {
        this.name = cityObj.getString("name");
        this.country = cityObj.getString("country");

        JSONObject coordObj = cityObj.getJSONObject("coord");
        this.latitude = coordObj.getDouble("lat");
        this.longitude = coordObj.getDouble("lon");
    }
    
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}