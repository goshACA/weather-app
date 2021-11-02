package com.daily.weather.view;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import com.daily.weather.R;
import com.daily.weather.model.WeatherModel;
import com.daily.weather.networking.GetWeatherData;
import com.daily.weather.networking.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText city;
    private TextView temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = findViewById(R.id.city);
        temp = findViewById(R.id.temp);
        findViewById(R.id.click).setOnClickListener(v->{
            findData();
        });

    }

    private void findData(){
        GetWeatherData service = RetrofitClientInstance.getInstance().createApiService();
        Call<WeatherModel> res = service.getWeatherOfCity(city.getText().toString(), getString(R.string.app_id));
        res.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
              if(response.body() != null)
                temp.setText(response.body().getTemperature().getTemp() + "");
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                Log.d("zz", "zz");
            }
        });
    }
}
