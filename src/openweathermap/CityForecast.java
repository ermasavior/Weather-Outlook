package openweathermap;
import java.util.ArrayList;

public class CityForecast {
    private City city;
    private ArrayList<HourlyForecast> forecastlist;

    public void setCity(City city) {
        this.city = city;
    }
    
    public CityForecast(JSONObject forecast) throws ForecasterException {
        try {
            Object objForecast = parser.parse(forecast);
            JSONArray array = (JSONArray) obj;

        } catch (ParseException pe) {
            new ForecasterException("Error Parsing Input");
        }
    }

    public ArrayList<HourlyForecast> getForecastList() {
        return forecastlist;
    }

    public void addHourlyForecast(HourlyForecast forecast) {
        forecastlist.add(forecast);
    }
}