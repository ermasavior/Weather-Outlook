package openweathermap;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Receive city name input and connecting to openweathermap API
 */
public class ForecasterClient {
    //private ArrayList<CityForecast> forecastresults;
    //private CityForecast forecastresult;
    private String apikey;
    private ForecasterURLConnection connection;

    public ForecasterClient(String apikey) {
        this.connection = new ForecasterURLConnection(apikey);
        //this.forecastresults = new ArrayList<CityForecast>();
    }

    /*public ArrayList<CityForecast> getForecastResults() {
        return forecastresults;
    }*/

    /*public CityForecast getForecastResult() {
        return forecastresult;
    }*/

    public CityForecast searchCityForecast(String cityname) throws ForecasterException {
        JSONObject cityforecastObj = connection.makeRequest(cityname);
        CityForecast forecastresult = new CityForecast(cityforecastObj);
        return forecastresult;
    }
    
    /**
     * Search id of city name input through list of city (from openweathermap)
     */
    //public ArrayList<City> searchCity(String cityname) throws ForecasterException {
        //read and search citylist.json
        //ArrayList<City> cityList = new ArrayList<City>();
        //for each cityList
        //  JSONObject JSONCityForecast = connection.makeRequest(cityID)
        //  CityForecast cityForecast = new CityForecast(JSONCityForecast);
        //  forecastresults.add(cityForecast);
    //}
}