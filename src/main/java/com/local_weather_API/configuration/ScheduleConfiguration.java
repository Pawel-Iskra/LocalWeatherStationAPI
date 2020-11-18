package com.local_weather_API.configuration;

import com.local_weather_API.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleConfiguration {

    private final WeatherService weatherService;

    @Autowired
    public ScheduleConfiguration(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @Scheduled(cron = "${cron.weather.stats}")
    public void getWeatherForCityList() {
        String[] cities = new String[]{"Szczecin", "Katowice", "Gdansk", "Lodz",
                "Warszawa", "Krakow", "Wroclaw", "Gdynia", "Poznan", "Bydgoszcz"};

        int numberOfCities = cities.length;
        for (int i = 0; i < numberOfCities; i++) {
            weatherService.getCurrentWeatherForCityName(cities[i]);
        }

    }
}
