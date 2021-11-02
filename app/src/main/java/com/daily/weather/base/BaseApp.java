package com.daily.weather.base;

import android.app.Application;

import com.daily.weather.db.DataDao;
import com.daily.weather.repository.DataRepository;

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private DataDao getDatabaseDao() {
        return AppDatabase.getInstance(this).databaseDao();
    }

    public DataRepository getRepository() {
        return DataRepository.getInstance(getDatabaseDao());
    }
}
