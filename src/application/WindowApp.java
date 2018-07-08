package application;

import openweathermap.CityForecast;
import openweathermap.ForecasterClient;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.*;

public class WindowApp extends JFrame {
    private final JLabel titleText = new JLabel("Weather Outlook\n");
    private JTextField searchBox = new JTextField(40);
    private JButton searchButton = new JButton();
    private WeatherVisualization resultPanel;
    private ForecasterClient forecaster;
    private CityForecast forecastresult;

    public WindowApp(ForecasterClient forecaster) {
        this.forecaster = forecaster;
        initUI();
    }

    private void initUI() {
        getContentPane().setLayout(new FlowLayout());

        searchButton.addActionListener((ActionEvent event) -> {
            String input = searchBox.getText();
            try {
                /*Thread object = new Thread(new Forecaster(forecaster, input));
                object.start();*/
                if (input.length() != 0) {
                    forecastresult = forecaster.searchCityForecast(input);
                    resultPanel = new WeatherVisualization(forecastresult);
                    add(resultPanel);
                }
            } catch (Exception e) {
                showErrorPanel(e.getMessage());
            }
        });

        JPanel panel = new JPanel(); //Create a JPanel
        //panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        //titleText.setLocation(500,500);
        titleText.setFont(new Font("Arial", Font.PLAIN, 50));
        searchBox.setFont(new Font("Arial", Font.PLAIN, 25));
        searchButton.setText("Search City");
        //panel.add(titleText); // Add the label to the panel
        //panel.add(searchBox); // Add the JTextField to the panel
        //panel.add(searchButton);

        //WeatherVisualization weatherview= new WeatherVisualization(CityForecast forecastresult);
        //panel.add(weatherview);
        //getContentPane().add(panel); // Add the panel to the JFrame

        getContentPane().add(titleText);
        getContentPane().add(searchBox);
        getContentPane().add(searchButton);
        getContentPane().add(panel);
        pack();

        setTitle("Weather Outlook");
        setSize(1200, 800);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void showErrorPanel(String errmsg) {
        JLabel msg = new JLabel("ERROR: " + errmsg);
        getContentPane().add(msg);
    }
}
/*
class Forecaster implements Runnable
{
    private ForecasterClient forecaster;
    private CityForecast forecastresult;
    private String cityinput;

    Forecaster(ForecasterClient forecast, String cityinput) {
        forecaster = forecast;
        this.cityinput = cityinput;
    }
    public void run()
    {
        try
        {
            CityForecast forecastresult = forecaster.searchCityForecast(cityinput);
        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception is caught");
            e.printStackTrace();
        }
    }

    public CityForecast getForecastResult() {
        return forecastresult;
    }
}*/
