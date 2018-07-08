package openweathermap;
import java.util.ArrayList;
import org.json.*;

public class CityForecast {
    private City city;
    private ArrayList<HourlyForecast> hourlyforecastlist = new ArrayList<>();

    public City getCity() {
        return city;
    }

    public ArrayList<HourlyForecast> getHourlyForecastList() {
        return hourlyforecastlist;
    }
    
    public CityForecast(JSONObject forecastresult) throws ForecasterException {
        try {
            city = new City(forecastresult.getJSONObject("city"));
            JSONArray forecastlist = (JSONArray) forecastresult.get("list");
            for (int i = 0; i < forecastlist.length(); i+=12) {
                HourlyForecast forecast = new HourlyForecast(forecastlist.getJSONObject(i));
                addHourlyForecast(forecast);
            }
        } catch (JSONException pe) {
            throw new ForecasterException(pe.getMessage());
        }
    }

    public void addHourlyForecast(HourlyForecast forecast) {
        hourlyforecastlist.add(forecast);
    }
}