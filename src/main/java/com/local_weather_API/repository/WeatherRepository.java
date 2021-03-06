package com.local_weather_API.repository;

import com.local_weather_API.models.Location;
import com.local_weather_API.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    List<Weather> findByLocation (Location location);
}
