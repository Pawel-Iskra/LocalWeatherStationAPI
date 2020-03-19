package com.local_weather_API.business_logic.transformations;

public interface WeathersConditions {

    float getTemperature();
    float getTemperatureSensed();
    int getPressure();
    int getHumidity();
    float getWindSpeed();
    int getWindDegrees();
}
