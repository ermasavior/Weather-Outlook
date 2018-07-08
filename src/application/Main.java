package application;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import openweathermap.*;

public class Main {
    private static File apikeyFile = new File("..\\Weather-Outlook\\data\\apikey.txt");

    private static String readAPIkey() {
        String apikey = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(apikeyFile));

            String text;
            while ((text = br.readLine()) != null)
                apikey += text;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apikey;
    }

    public static void main(String[] args) {
        String apikey = readAPIkey();
        ForecasterClient forecaster = new ForecasterClient(apikey);
        EventQueue.invokeLater(() -> {
            WindowApp window = new WindowApp(forecaster);
            window.setVisible(true);
        });

        /*ForecasterClient client = new ForecasterClient("20a37921e6b890f1c14a60c19afdf8ec");
        try {
            CityForecast result = client.searchCityForecast("Manado");
            System.out.println(result.getCity().getName());
            System.out.println(result.getCity().getCountry());
            System.out.println(result.getHourlyForecastList().get(0).getWeather().description);
            System.out.println(result.getHourlyForecastList().size());
        } catch (ForecasterException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }*/
    }
}