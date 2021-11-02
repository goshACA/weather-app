package com.daily.weather.base;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.daily.weather.db.DataDao;
import com.daily.weather.model.WeatherModel;

@Database(entities = {WeatherModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static String DATABASE_NAME = "wallpaper_db";

    public abstract DataDao databaseDao();

    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {

        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = create(context);
                }
            }
        }
        return instance;
    }

    private static AppDatabase create(Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class,
                DATABASE_NAME).build();
    }
}
