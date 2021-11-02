package com.daily.weather.db.converters;

import android.arch.persistence.room.TypeConverter;
import android.content.Intent;

import com.daily.weather.model.Temperature;

public class TempConverter {
    @TypeConverter
    public String fromTemp(Temperature temperature){
        return "Temp:" + temperature.getTemp() + "/Pressure:" + temperature.getPressure()
                + "/Humidity:" + temperature.getHumidity() + "/TempMin:" + temperature.getTempMin() + "TempMax" + temperature.getTempMax();
    }

    @TypeConverter
    public Temperature toTemperature(String str){
        Temperature temperature = new Temperature();
        temperature.setTemp(Double.valueOf( str.substring(str.indexOf(":"), str.indexOf('/'))));
        temperature.setPressure(Double.valueOf( str.substring(str.indexOf("/Pressure:") + "/Pressure:".length(), str.indexOf("/Humidity:"))));
        temperature.setHumidity(Integer.valueOf( str.substring(str.indexOf("/Humidity:") + "/Humidity:".length(), str.indexOf("/TempMin:"))));
        temperature.setTempMin(Double.valueOf( str.substring(str.indexOf("/TempMin:") + "/TempMin:".length(), str.indexOf("/TempMax:"))));
        temperature.setTempMax(Double.valueOf( str.substring(str.indexOf("/TempMax:") + "/TempMax:".length())));
        return temperature;
    }
}
