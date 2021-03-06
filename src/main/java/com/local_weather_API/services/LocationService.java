package com.local_weather_API.services;

import com.local_weather_API.transformations.LocationDtoTransformer;
import com.local_weather_API.models.Location;
import com.local_weather_API.repository.LocationRepository;
import com.local_weather_API.repository.WeatherRepository;
import com.local_weather_API.dtos.LocationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationDtoTransformer locationDtoTransformer;
    private final WeatherRepository weatherRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository, LocationDtoTransformer locationDtoTransformer,
                           WeatherRepository weatherRepository) {
        this.locationRepository = locationRepository;
        this.locationDtoTransformer = locationDtoTransformer;
        this.weatherRepository = weatherRepository;
    }

    public List<LocationDto> getAllLocationsFromDatabase() {
        return locationRepository.findAllByOrderByCityAsc()
                .stream()
                .map(location -> locationDtoTransformer.locationFromEntityToDto(location))
                .collect(Collectors.toList());
    }

    public List<LocationDto> getLocationsForCountry(String country) {
        return locationRepository.findByCountryOrderByCityAsc(country)
                .stream()
                .map(location -> locationDtoTransformer.locationFromEntityToDto(location))
                .collect(Collectors.toList());
    }

    public String removeLocationFromDatabaseWithAllItsWeathers(String city) {
        Location locationToDelete = locationRepository.findByCity(city)
                .orElseThrow(() -> {
                    throw new NoSuchElementException("No such location found in database.");
                });
        weatherRepository.findByLocation(locationToDelete)
                .stream()
                .forEach(weather -> weatherRepository.delete(weather));
        locationRepository.delete(locationToDelete);

        return "location and its weather history was removed from db";
    }

}
