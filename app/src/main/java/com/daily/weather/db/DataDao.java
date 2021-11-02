package com.daily.weather.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.daily.weather.model.WeatherModel;

import java.util.List;

@Dao
public interface DataDao {

    @Query("SELECT * FROM " + WeatherModel.TABLE_NAME + " WHERE id = :id")
    LiveData<WeatherModel> getSingleWeather(long id);

    @Query("SELECT * FROM " + WeatherModel.TABLE_NAME)
    LiveData<List<WeatherModel>> getAllSavedWeathers();

    @Query("SELECT * FROM " + WeatherModel.TABLE_NAME + " WHERE sys_country = :country")
    LiveData<List<WeatherModel>> getCitiesByCountry(String country);

    @Update
    void insertWeather(WeatherModel weatherModel);

    @Update
    void insertWeatherList(List<WeatherModel> weatherModelList);

    @Delete
    void deleteWeatherItem(WeatherModel weatherModel);
}
