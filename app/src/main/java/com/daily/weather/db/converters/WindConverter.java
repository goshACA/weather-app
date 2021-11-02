package com.daily.weather.db.converters;

import android.arch.persistence.room.TypeConverter;

import com.daily.weather.model.Wind;

public class WindConverter {
    @TypeConverter
    public String fromCoord(Wind wind){
        return "Deg:" + wind.getDeg() + "/Speed:" + wind.getSpeed();
    }

    @TypeConverter
    public Wind toCoord(String str){
        Wind wind = new Wind();
        wind.setDeg(Double.valueOf(str.substring(str.indexOf(':') + 1, str.indexOf('/'))));
        wind.setSpeed(Double.valueOf(str.substring(str.lastIndexOf(':') + 1)));
        return wind;
    }
}
