package com.daily.weather.db.converters;

import android.arch.persistence.room.TypeConverter;

import com.daily.weather.model.Coord;

public class CoordConverter {
    @TypeConverter
    public String fromCoord(Coord coord){
        return "Lon:" + coord.getLon() + "/Lat:" + coord.getLat();
    }

    @TypeConverter
    public Coord toCoord(String str){
       Coord coord = new Coord();
       coord.setLon(Double.valueOf(str.substring(str.indexOf(':') + 1, str.indexOf('/'))));
        coord.setLat(Double.valueOf(str.substring(str.lastIndexOf(':') + 1)));
       return coord;
    }
}
