package com.local_weather_API.external_APIs.weatherbit.model;

import com.local_weather_API.business_logic.transformations.WeathersConditions;

public class WeatherFromWeatherBit implements WeathersConditions {
    
    private Data[] data;

    public WeatherFromWeatherBit() {
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    @Override
    public float getTemperature() {
        return getData()[0].getTemp();
    }

    @Override
    public float getTemperatureSensed() {
        return getData()[0].getAppTemp();
    }

    @Override
    public int getPressure() {
        return (int) getData()[0].getPres();
    }

    @Override
    public int getHumidity() {
        return getData()[0].getHumidity();
    }

    @Override
    public float getWindSpeed() {
        return getData()[0].getWindSpeed();
    }

    @Override
    public int getWindDegrees() {
        return getData()[0].getWindDir();
    }
}
