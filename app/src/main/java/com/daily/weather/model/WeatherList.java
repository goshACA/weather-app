package com.daily.weather.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class WeatherList {
    private List<Weather> weatherList = new ArrayList<>();

    public WeatherList(){}

    public List<Weather> getWeatherList(){
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList){
        this.weatherList = weatherList;
    }

    public void addItem(Weather weather){
        if(weatherList == null)
            throw new NullPointerException();
        weatherList.add(weather);
    }
}
