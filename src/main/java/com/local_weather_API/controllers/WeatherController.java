package com.local_weather_API.controllers;

import com.local_weather_API.dtos.WeatherDto;
import com.local_weather_API.dtos.WeatherDtoForCityList;
import com.local_weather_API.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<WeatherDto> getCurrentWeatherForCityName(@RequestParam String city) {
        return new ResponseEntity<>(weatherService.getCurrentWeatherForCityName(city), HttpStatus.OK);
    }

    @GetMapping("/history/{city}")
    public ResponseEntity<List<WeatherDtoForCityList>> getWeatherHistoryForCityName(@PathVariable String city) {
        return new ResponseEntity<>(weatherService.getWeatherHistoryForCityName(city), HttpStatus.OK);
    }

}

