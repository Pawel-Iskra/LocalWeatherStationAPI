package com.local_weather_API.transformations;

import com.local_weather_API.external_APIs.darksky.model.WeatherFromDarkSkyApi;
import com.local_weather_API.external_APIs.openweathermap.model.WeatherFromOpenWeatherApi;
import com.local_weather_API.external_APIs.weatherbit.model.WeatherFromWeatherBit;
import com.local_weather_API.models.Location;
import com.local_weather_API.models.Weather;
import com.local_weather_API.dtos.WeatherDto;
import com.local_weather_API.dtos.WeatherDtoForCityList;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class WeatherDtoTransformer {

    public WeatherDto weatherFromApisToDto(WeatherFromOpenWeatherApi weatherFromOpenWeatherApi,
                                           WeatherFromDarkSkyApi weatherFromDarkSkyApi,
                                           WeatherFromWeatherBit weatherFromWeatherBit) {
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setCityName(weatherFromOpenWeatherApi.getCityName());
        weatherDto.setCountryName(weatherFromOpenWeatherApi.getSys().getCountry());
        weatherDto.setLongitude(weatherFromOpenWeatherApi.getCoord().getLongitude());
        weatherDto.setLatitude(weatherFromOpenWeatherApi.getCoord().getLatitude());
        weatherDto.setMainWeatherType(weatherFromOpenWeatherApi.getWeather()[0].getMainWeatherType());
        weatherDto.setWeatherDescription(weatherFromOpenWeatherApi.getWeather()[0].getDescription());
        weatherDto.setTemperature(getAverageTemperature(
                weatherFromOpenWeatherApi, weatherFromDarkSkyApi, weatherFromWeatherBit));
        weatherDto.setTemperatureSensed(getAverageTemperatureSensed(
                weatherFromOpenWeatherApi, weatherFromDarkSkyApi, weatherFromWeatherBit));
        weatherDto.setPressure(getAveragePressure(
                weatherFromOpenWeatherApi, weatherFromDarkSkyApi, weatherFromWeatherBit));
        weatherDto.setHumidity(getAverageHumidity(
                weatherFromOpenWeatherApi, weatherFromDarkSkyApi, weatherFromWeatherBit));
        weatherDto.setWindSpeed(getAverageWindSpeed(
                weatherFromOpenWeatherApi, weatherFromDarkSkyApi, weatherFromWeatherBit));
        weatherDto.setWindDegrees(getAverageWindDegrees(
                weatherFromOpenWeatherApi, weatherFromWeatherBit));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        weatherDto.setDateTime(dtf.format(now).toString());
        return weatherDto;
    }

    public Weather weatherFromDtoToEntity(WeatherDto weatherDto) {
        Weather weather = new Weather();
        weather.setMainWeatherType(weatherDto.getMainWeatherType());
        weather.setDescription(weatherDto.getWeatherDescription());
        weather.setTemperature(weatherDto.getTemperature());
        weather.setTemperatureFeelsLike(weatherDto.getTemperatureSensed());
        weather.setPressure(weatherDto.getPressure());
        weather.setHumidity(weatherDto.getHumidity());
        weather.setWindSpeed(weatherDto.getWindSpeed());
        weather.setWindDegrees(weatherDto.getWindDegrees());
        weather.setDateTime(weatherDto.getDateTime());
        weather.setLocation(new Location());
        return weather;
    }

    public WeatherDto weatherFromEntityToDto(Weather weather) {
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setCityName(weather.getLocation().getCity());
        weatherDto.setCountryName(weather.getLocation().getCountry());
        weatherDto.setLongitude(weather.getLocation().getLongitude());
        weatherDto.setLatitude(weather.getLocation().getLatitude());
        weatherDto.setMainWeatherType(weather.getMainWeatherType());
        weatherDto.setWeatherDescription(weather.getDescription());
        weatherDto.setTemperature(weather.getTemperature());
        weatherDto.setTemperatureSensed(weather.getTemperatureFeelsLike());
        weatherDto.setPressure(weather.getPressure());
        weatherDto.setHumidity(weather.getHumidity());
        weatherDto.setWindSpeed(weather.getWindSpeed());
        weatherDto.setWindDegrees(weather.getWindDegrees());
        weatherDto.setDateTime(weather.getDateTime());
        return weatherDto;
    }

    public WeatherDtoForCityList weatherFromEntityToWeatherDtoForCityList(Weather weather) {
        WeatherDtoForCityList weatherDtoForCityList = new WeatherDtoForCityList();
        weatherDtoForCityList.setMainWeatherType(weather.getMainWeatherType());
        weatherDtoForCityList.setWeatherDescription(weather.getDescription());
        weatherDtoForCityList.setTemperature(weather.getTemperature());
        weatherDtoForCityList.setTemperatureSensed(weather.getTemperatureFeelsLike());
        weatherDtoForCityList.setPressure(weather.getPressure());
        weatherDtoForCityList.setHumidity(weather.getHumidity());
        weatherDtoForCityList.setWindSpeed(weather.getWindSpeed());
        weatherDtoForCityList.setWindDegrees(weather.getWindDegrees());
        weatherDtoForCityList.setDateTime(weather.getDateTime());
        return weatherDtoForCityList;
    }

    private float getAverageTemperature(WeathersConditions... weathersConditions) {
        float result = 0;
        int size = weathersConditions.length;
        for (int i = 0; i < size; i++)
            result = result + weathersConditions[i].getTemperature();
        return result / size;
    }

    private float getAverageTemperatureSensed(WeathersConditions... weathersConditions) {
        float result = 0;
        int size = weathersConditions.length;
        for (int i = 0; i < size; i++)
            result = result + weathersConditions[i].getTemperatureSensed();
        return result / size;
    }

    private int getAveragePressure(WeathersConditions... weathersConditions) {
        int result = 0;
        int size = weathersConditions.length;
        for (int i = 0; i < size; i++)
            result = result + weathersConditions[i].getPressure();
        return result / size;
    }

    private int getAverageHumidity(WeathersConditions... weathersConditions) {
        int result = 0;
        int size = weathersConditions.length;
        for (int i = 0; i < size; i++)
            result = result + weathersConditions[i].getHumidity();
        return result / size;
    }

    private float getAverageWindSpeed(WeathersConditions... weatherConditions) {
        float result = 0;
        int size = weatherConditions.length;
        for (int i = 0; i < size; i++)
            result = result + weatherConditions[i].getWindSpeed();
        return result / size;
    }

    private int getAverageWindDegrees(WeathersConditions... weathersConditions) {
        int result = 0;
        int size = weathersConditions.length;
        for (int i = 0; i < size; i++)
            result = result + weathersConditions[i].getWindDegrees();
        return result / size;
    }

}
