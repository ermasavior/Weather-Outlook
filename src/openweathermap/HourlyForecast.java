package openweathermap;

import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class HourlyForecast {
    class Wind {
        double speed;
        double degree;
    }
    class Weather {
        String main;
        String description;
    }

    private String time;
    private double temp;
    private double humidity;
    private double sea_level;
    private double grnd_level;
    private double temp_kf;
    private double cloudiness;
    private double pressure;
    private Wind wind;
    private Weather weather;

    public String getTime() {
        return time;
    }

    public double getTemp() {
        return temp;
    }

    public HourlyForecast(JSONObject forecast) {
        try {
            Object obj = parser.parse(forecast);
            JSONArray array = (JSONArray) obj;

        } catch (ParseException pe) {	
            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }
    }
}