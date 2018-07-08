package application;

import javax.imageio.ImageIO;
import javax.swing.*;
import openweathermap.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class WeatherVisualization extends JPanel {
    private final String imgaddress = "..\\Weather-Outlook\\image\\";
    private final String bgaddress = imgaddress + "bg.jpg";
    private CityForecast cityForecast;
    private ArrayList<JPanel> hourlyforecastPanel;

    public WeatherVisualization(CityForecast forecast) {
        cityForecast = forecast;
        //UIDesign();
    }

    @Override
    protected void paintComponent(Graphics g) {
        try {
            final BufferedImage image = ImageIO.read(new File(bgaddress));
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void UIDesign() {
        JLabel cityName = new JLabel(cityForecast.getCity().getName() + ", ");
        JLabel country = new JLabel(cityForecast.getCity().getCountry());
        JLabel coordinate = new JLabel("Coord: "+ cityForecast.getCity().getLatitude() + ", " +
                                cityForecast.getCity().getLongitude());
        ArrayList<HourlyForecast> forecasts = cityForecast.getHourlyForecastList();
        setHourlyForecastPanel(forecasts);

        cityName.setFont(new Font("Arial", Font.BOLD, 30));
        country.setFont(new Font("Arial", Font.BOLD, 30));
        add(cityName);
        add(country);
        add(coordinate);
        for (JPanel forecastpanel: hourlyforecastPanel) {
            add(forecastpanel);
        }
    }

    private void setHourlyForecastPanel(ArrayList<HourlyForecast> forecasts) {
        for (HourlyForecast hourlyForecast: forecasts) {
            JPanel forecastPanel = new JPanel();
            JLabel time = new JLabel("Time: " + hourlyForecast.getTime());
            JLabel weathercond = new JLabel("Weather:" + hourlyForecast.getWeather().main + ": "
                    + hourlyForecast.getWeather().description);
            JLabel temp = new JLabel("Temp:" + hourlyForecast.getTemp() + "K ");
            JLabel humidity = new JLabel("Humidity: " + hourlyForecast.getHumidity() + "% ");
            JLabel pressure = new JLabel("Pressure: " + hourlyForecast.getPressure() + "% ");
            JLabel wind = new JLabel("Wind: " + hourlyForecast.getWind().degree + "degree. Speed: "
                    + hourlyForecast.getWind().speed);
            forecastPanel.add(time);
            forecastPanel.add(weathercond);
            forecastPanel.add(temp);
            forecastPanel.add(humidity);
            forecastPanel.add(pressure);
            forecastPanel.add(wind);
            hourlyforecastPanel.add(forecastPanel);
        }
    }
}
