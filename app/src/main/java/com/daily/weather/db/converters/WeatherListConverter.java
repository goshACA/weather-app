package com.daily.weather.db.converters;

import android.arch.persistence.room.TypeConverter;

import com.daily.weather.model.Weather;
import com.daily.weather.model.WeatherList;

public class WeatherListConverter {

    @TypeConverter
    public String fromList(WeatherList weatherList) {
        StringBuilder stringBuilder = new StringBuilder();
        WeatherConverter weatherConverter = new WeatherConverter();
        for (Weather weather : weatherList.getWeatherList()) {
            stringBuilder.append(weatherConverter.fromWeather(weather)).append('|');
        }
        return stringBuilder.toString();
    }

    @TypeConverter
    public WeatherList toList(String str) {
        WeatherList res = new WeatherList();
        String[] weatherStrings = str.split("|");
        WeatherConverter weatherConverter = new WeatherConverter();
        for (String strItem : weatherStrings) {
            res.addItem(weatherConverter.toWeather(strItem));
        }
        return res;
    }
}
