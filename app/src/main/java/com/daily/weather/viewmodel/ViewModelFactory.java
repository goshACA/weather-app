package com.daily.weather.viewmodel;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private Application mApplication;

    public ViewModelFactory(Application application) {
        mApplication = application;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.equals(MainViewModel.class))
            return (T) new MainViewModel(mApplication);

        else if (modelClass.equals(SavedListTemperatureViewModel.class))
            return (T) new SavedListTemperatureViewModel(mApplication);

        return (T) new MainViewModel(mApplication);
    }
}
