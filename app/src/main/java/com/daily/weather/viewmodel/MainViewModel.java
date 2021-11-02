package com.daily.weather.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.daily.weather.base.BaseApp;
import com.daily.weather.model.WeatherModel;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    public MainViewModel(@NonNull Application application) {
        super(application);
    }



    public void insertWeather(WeatherModel weatherModel){
        ((BaseApp)(getApplication())).getRepository().insertWeather(weatherModel);
    }

    public void insertList(List<WeatherModel> list){
        ((BaseApp)(getApplication())).getRepository().insertWeatherList(list);

    }
}
