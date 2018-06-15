# Weather Outlook
Weather-Outlook is a weather forecaster made with Java application to show current state weather or weather prediction of certain location anywhere on earth. This program is implemented using Java Swing as the User Interface. It fetched weather data from [OpenWeatherMap API](https://openweathermap.org/api).

## What is API?
---
> An application programming interface (API) is a set of routines, protocols, and tools for building software applications.

API is the backbone of a project we want to build. API acts as a *messenger* of the project. It receives programmer's requests and then sends responses. The requests could be anything (get data or do something), depends on the features of an API.

Here is a simple gif of how API works. The gif below illustrates API of an open banking system.
![How API works](/image/api-explanation.gif)
*(Image Source: https://medium.com/@JanisGraubins/open-banking-api-explained-in-3-gifs-b806f14ca2ca)*

### Explanation
The idea is to have the application system connect to the banking server with a request to fetch detailed information about user account. The server would receive response from banking server, process it, and send back requested information to the app.

## Open Weather API
---
Open Weather API is an API which provides weather and atmosphere condition data of a location. The weather data contains humidity, wind, and state of weather either on current time or as prediction for the next hour(s).
### Current Weather Data
Current weather is a real time weather data from more than 40.000 weather stations which updates frequently. The number of locations covered all around the world is 200.000 cities. The weather can be requested by city name, city ID, or ZIP code.
### Weather Prediction Data
Weather forecaster fetched weather data of certain location every 3 hours. It may predict weather data to the next 5 days up to 16 days. This program will use 5 day forecaster for free.

## Package Structure
---
The-Weather-Outlook program structured into three packages based on each responsibility:
1. **Application**, controls Java application (including app window, design, on-click actions, etc). Application package consists of 3 classes:
    - UIDesign: components of a window.
    - WeatherVisualization: data visualization of weather condition.
    - AppWindow: main window of the program.
    - Main: main program which triggers AppWindow.

2. **WeatherForecast**, gets data from OpenWeatherMap API.
    - DataFetcher: API requester. 
    - Weather: weather data (humidity, wind, state of weather) of a location.

## Todo List
---
- [ ] Application
    - [ ] UIDesign
    - [ ] WeatherVisualization
    - [ ] AppWindow
    - [ ] Main
- [ ] WeatherForecast
    - [ ] DataFetcher
    - [ ] Weather


## How to Run
---
TBD

## Screenshots
---
TBD

## Author
---
**Erma Safira Nurmasyita - 13516072**

13516072@std.stei.itb.ac.id