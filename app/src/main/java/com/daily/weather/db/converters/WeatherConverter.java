package com.daily.weather.db.converters;

import android.arch.persistence.room.TypeConverter;

import com.daily.weather.model.Weather;

public class WeatherConverter {
    @TypeConverter
    public String fromWeather(Weather weather){
        return "Id:" + weather.getId() + "/Description:" + weather.getDescription()
                + "/Main:" + weather.getMain() + "/Icon:" + weather.getIcon();
    }

    @TypeConverter
    public Weather toWeather(String str){
        Weather weather = new Weather();
        weather.setId(Integer.valueOf( str.substring(str.indexOf(":"), str.indexOf('/'))));
        weather.setDescription(str.substring(str.indexOf("/Description:") + "/Description:".length(), str.indexOf("/Main:")));
        weather.setMain(str.substring(str.indexOf("/Main:") + "/Main:".length(), str.indexOf("/Icon:")));
        weather.setIcon(str.substring(str.indexOf("/Icon:") + "/Icon:".length()));
        return weather;
    }
}

