package com.daily.weather.view;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toolbar;

import com.daily.weather.R;
import com.daily.weather.view.adapter.WeatherAdapter;
import com.daily.weather.viewmodel.SavedListTemperatureViewModel;
import com.daily.weather.viewmodel.ViewModelFactory;

public class SavedListTemperatureActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private WeatherAdapter weatherAdapter;

    private SavedListTemperatureViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_list_temperature);
        init();
        bindViewModel();
        initUI();
    }

    private void init(){
        toolbar = findViewById(R.id.toolbar_saved_temp_list);
        recyclerView = findViewById(R.id.rec_view_saved_temp_list);
    }

    private void initUI(){
        weatherAdapter = new WeatherAdapter();
        weatherAdapter.setData(viewModel.getAllSavedWeathers().getValue());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(weatherAdapter);
    }

    private void bindViewModel(){
        viewModel = ViewModelProviders.of(this, new ViewModelFactory(getApplication())).get(SavedListTemperatureViewModel.class);
    }
}
