package com.daily.weather.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.daily.weather.base.BaseApp;
import com.daily.weather.model.WeatherModel;

import java.util.List;

public class SavedListTemperatureViewModel extends AndroidViewModel {
    public SavedListTemperatureViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<WeatherModel>> getAllSavedWeathers(){
        return ((BaseApp)(getApplication())).getRepository().getAllSavedWeathers();
    }
}
