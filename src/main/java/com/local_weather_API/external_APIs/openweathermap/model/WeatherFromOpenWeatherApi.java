package com.local_weather_API.external_APIs.openweathermap.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.local_weather_API.transformations.WeathersConditions;

public class WeatherFromOpenWeatherApi implements WeathersConditions{

    private Weather[] weather;
    private Main main;
    private Wind wind;
    private Coord coord;
    private Sys sys;
    private String cityName;

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    @JsonProperty("name")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    @Override
    public float getTemperature() {
        return getMain().getTemperature();
    }

    @Override
    public float getTemperatureSensed() {
        return getMain().getTemperatureFeelsLike();
    }

    @Override
    public int getPressure() {
        return getMain().getPressure();
    }

    @Override
    public int getHumidity() {
        return getMain().getHumidity();
    }

    @Override
    public float getWindSpeed() {
        return getWind().getSpeed();
    }

    @Override
    public int getWindDegrees() {
        return getWind().getDegrees();
    }
}
