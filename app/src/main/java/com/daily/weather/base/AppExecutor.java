package com.daily.weather.base;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutor {
    private final Executor diskIO;

    private AppExecutor(Executor diskIO) {
        this.diskIO = diskIO;
    }

    public AppExecutor() {
        this(Executors.newSingleThreadExecutor());
    }

    public Executor diskIO() {
        return diskIO;
    }
}
