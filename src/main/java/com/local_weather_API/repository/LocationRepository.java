package com.local_weather_API.repository;

import com.local_weather_API.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByCity(String city);

    List<Location> findAllByOrderByCityAsc();

    List<Location> findByCountryOrderByCityAsc(String country);
}