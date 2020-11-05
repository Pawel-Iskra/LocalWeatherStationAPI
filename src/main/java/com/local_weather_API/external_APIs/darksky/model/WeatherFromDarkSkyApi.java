package com.local_weather_API.external_APIs.darksky.model;

import com.local_weather_API.transformations.WeathersConditions;

public class WeatherFromDarkSkyApi implements WeathersConditions {

    private Currently currently;

    public WeatherFromDarkSkyApi() {
    }

    public Currently getCurrently() {
        return currently;
    }

    public void setCurrently(Currently currently) {
        this.currently = currently;
    }

    @Override
    public float getTemperature() {
        return getCurrently().getTemperature();
    }

    @Override
    public float getTemperatureSensed() {
        return getCurrently().getApparentTemperature();
    }

    @Override
    public int getPressure() {
        return getCurrently().getPressure();
    }

    @Override
    public int getHumidity() {
        return (int) (getCurrently().getHumidity() * 100);
    }

    @Override
    public float getWindSpeed() {
        return getCurrently().getWindSpeed();
    }

    @Override
    public int getWindDegrees() {
        return 0;
    }
}
