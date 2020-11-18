package com.local_weather_API.controllers;

import com.local_weather_API.dtos.LocationDto;
import com.local_weather_API.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/location")
@RestController
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<LocationDto>> getAllLocationsFromDatabase() {
        return new ResponseEntity<>(locationService.getAllLocationsFromDatabase(), HttpStatus.OK);
    }

    @GetMapping("/{country}")
    public ResponseEntity<List<LocationDto>> getLocationsForCountry(@PathVariable String country) {
        return new ResponseEntity<>(locationService.getLocationsForCountry(country), HttpStatus.OK);
    }

    @DeleteMapping("/{city}")
    public ResponseEntity<String> deleteLocationWithAllItsWeathers(@PathVariable String city) {
        return new ResponseEntity<>(
                locationService.removeLocationFromDatabaseWithAllItsWeathers(city), HttpStatus.OK);
    }


}
