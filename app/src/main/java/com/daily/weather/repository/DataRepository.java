package com.daily.weather.repository;

import android.arch.lifecycle.LiveData;

import com.daily.weather.base.AppExecutor;
import com.daily.weather.db.DataDao;
import com.daily.weather.model.WeatherModel;
import com.daily.weather.networking.GetWeatherData;
import com.daily.weather.networking.RetrofitClientInstance;

import java.util.List;

public class DataRepository {
    private static DataRepository instance;
    private GetWeatherData apiService;
    private DataDao weatherDao;
    private AppExecutor appExecutor;


    private DataRepository(DataDao weatherDao) {
        this.weatherDao = weatherDao;
        apiService = RetrofitClientInstance.getInstance().createApiService();
        appExecutor = new AppExecutor();

    }

    public static DataRepository getInstance(DataDao dataDao) {
        if (instance == null)
            instance = new DataRepository(dataDao);
        return instance;
    }


    public void insertWeather(WeatherModel weatherModel) {
        appExecutor.diskIO().execute(() -> {
            weatherDao.insertWeather(weatherModel);
        });

    }

    public void insertWeatherList(List<WeatherModel> weatherModelList) {
        appExecutor.diskIO().execute(() -> {
            weatherDao.insertWeatherList(weatherModelList);
        });
    }

    public LiveData<WeatherModel> getWeather(long id) {
        return weatherDao.getSingleWeather(id);
    }

    public LiveData<List<WeatherModel>> getCitiesWeatherByCountry(String country) {
        return weatherDao.getCitiesByCountry(country);
    }

    public LiveData<List<WeatherModel>> getAllSavedWeathers(){
        return weatherDao.getAllSavedWeathers();
    }

    public void removeWeather(WeatherModel weatherModel){
        appExecutor.diskIO().execute(() -> {
            weatherDao.deleteWeatherItem(weatherModel);
        });
    }


}
