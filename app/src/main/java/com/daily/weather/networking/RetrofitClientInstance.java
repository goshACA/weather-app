package com.daily.weather.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static RetrofitClientInstance instance;
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather/";

    private RetrofitClientInstance(){}

    public static RetrofitClientInstance getInstance(){
        if(instance == null)
            instance = new RetrofitClientInstance();
        return instance;
    }



    private  Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public GetWeatherData createApiService(){
        return getRetrofitInstance().create(GetWeatherData.class);
    }
}