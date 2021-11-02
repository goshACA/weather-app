package com.daily.weather.db.converters;

import android.arch.persistence.room.TypeConverter;
import android.content.Intent;

import com.daily.weather.model.Sys;

public class SysConverter {

    @TypeConverter
    public String fromSys(Sys sys){
        return "Type:" + sys.getType() + "/Id:" + sys.getId() + "/Message:" + sys.getMessage()
                + "/Country:" + sys.getCountry() + "/Sunrise:" + sys.getSunrise() + "/Sunset:" + sys.getSunset();
    }

    @TypeConverter
    public Sys toSys(String str){
        Sys sys = new Sys();
        sys.setType(Integer.valueOf(str.substring(str.indexOf(':'), str.indexOf('/'))));
        sys.setId(Integer.valueOf(str.substring(str.indexOf('/') + 4, str.indexOf("/Message:"))));
        sys.setMessage(Double.valueOf(str.substring(str.indexOf("/Message:") + 9, str.indexOf("/Country:"))));
        sys.setCountry(str.substring(str.indexOf("/Country:") + 9, str.indexOf("/Sunrise:")));
        sys.setSunrise(Integer.valueOf(str.substring(str.indexOf("/Sunrise:") + 9, str.indexOf("/Sunset:"))));
        sys.setSunset(Integer.valueOf(str.substring(str.indexOf("/Sunset:") + 8)));
        return sys;
    }
}
