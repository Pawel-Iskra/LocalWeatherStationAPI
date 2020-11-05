package com.local_weather_API.controllers;

import com.local_weather_API.dtos.WeatherDto;
import com.local_weather_API.dtos.WeatherDtoForCityList;
import com.local_weather_API.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public WeatherDto getCurrentWeatherForCityName(@RequestParam String city) {
        return weatherService.getCurrentWeatherForCityName(city);
    }

    @GetMapping("/history/{city}")
    public List<WeatherDtoForCityList> getWeatherHistoryForCityName(@PathVariable String city) {
        return weatherService.getWeatherHistoryForCityName(city);
    }

}

