package com.daily.weather.networking;

import com.daily.weather.model.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetWeatherData {

    @GET(".")
    Call<WeatherModel> getWeatherOfCity(@Query("q") String city, @Query("APPID") String appId);
}
