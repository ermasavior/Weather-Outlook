package openweathermap;

import org.json.*;
//import org.json.simple.parser.ParseException;
//import org.json.simple.parser.JSONParser;

public class HourlyForecast {
    public class Wind {
        public double speed;
        public double degree;
        Wind(JSONObject windObj) {
            speed = windObj.getDouble("speed");
            degree = windObj.getDouble("deg");
        }
    }
    public class Weather {
        public String main;
        public String description;
        Weather(JSONObject weatherObj) {
            main = weatherObj.getString("main");
            description = weatherObj.getString("description");
        }
    }
    private String time;
    private double temp;
    private double humidity;
    private double cloudiness;
    private double pressure;
    private Wind wind;
    private Weather weather;

    public HourlyForecast(JSONObject forecast) throws ForecasterException {
        try {
            time = forecast.get("dt_txt").toString();
            JSONObject forecastmain = forecast.getJSONObject("main");
            temp = forecastmain.getDouble("temp");
            humidity = forecastmain.getDouble("humidity");
            pressure = forecastmain.getDouble("pressure");
            cloudiness = forecast.getJSONObject("clouds").getDouble("all");
            wind = new Wind (forecast.getJSONObject("wind"));
            weather = new Weather (forecast.getJSONArray("weather").getJSONObject(0));
        } catch (JSONException pe) {
            throw new ForecasterException(pe.getMessage());
        }
    }

    public String getTime() {
        return time;
    }

    public double getTemp() {
        return temp;
    }
    public double getHumidity() {
        return humidity;
    }
    public double getCloudiness() {
        return cloudiness;
    }
    public double getPressure() {
        return pressure;
    }
    public Wind getWind() {
        return wind;
    }
    public Weather getWeather() {
        return weather;
    }
}