package application;

import openweathermap.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ForecasterClient client = new ForecasterClient("20a37921e6b890f1c14a60c19afdf8ec");
        try {
            CityForecast result = client.searchCityForecast("Kyiv");
            System.out.println(result.getCity().getName());
            System.out.println(result.getCity().getCountry());
            System.out.println(result.getHourlyForecastList().get(0).getWeather().description);
        } catch (ForecasterException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
