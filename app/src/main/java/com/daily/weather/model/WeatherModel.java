package com.daily.weather.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.daily.weather.db.converters.CoordConverter;
import com.daily.weather.db.converters.SysConverter;
import com.daily.weather.db.converters.TempConverter;
import com.daily.weather.db.converters.WeatherConverter;
import com.daily.weather.db.converters.WeatherListConverter;
import com.daily.weather.db.converters.WindConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = WeatherModel.TABLE_NAME)
public class WeatherModel {
    public final static String TABLE_NAME = "weather_data";

    @SerializedName("coord")
    @Expose
    @TypeConverters({CoordConverter.class})
    private Coord coord;
    @SerializedName("weather")
    @Expose
    @TypeConverters({WeatherListConverter.class})
    private WeatherList weather = null;
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("temperature")
    @Expose
    @TypeConverters({TempConverter.class})
    private Temperature temperature;
    @SerializedName("visibility")
    @Expose
    private Integer visibility;
    @SerializedName("wind")
    @Expose
    @TypeConverters({WindConverter.class})
    private Wind wind;
    @SerializedName("dt")
    @Expose
    private Integer dt;
    @SerializedName("sys")
    @Expose
    @Embedded(prefix = "sys_")
    @TypeConverters({SysConverter.class})
    private Sys sys;
    @SerializedName("timezone")
    @Expose
    private Integer timezone;
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cod")
    @Expose
    private Integer cod;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }




    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature main) {
        this.temperature = main;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }


    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public WeatherList getWeather() {
        return weather;
    }

    public void setWeather(WeatherList weather) {
        this.weather = weather;
    }
}