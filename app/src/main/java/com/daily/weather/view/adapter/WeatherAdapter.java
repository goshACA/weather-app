package com.daily.weather.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daily.weather.R;
import com.daily.weather.model.WeatherModel;

import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private List<WeatherModel> data;

    public WeatherAdapter() {
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        WeatherViewHolder weatherViewHolder = new WeatherViewHolder(LayoutInflater.from(viewGroup.getContext()
        ).inflate(R.layout.layout_recycler_item, viewGroup, false));
        //TODO: implement click
        return weatherViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int i) {
        WeatherModel item = data.get(i);
        weatherViewHolder.txtCity.setText(item.getName());
        weatherViewHolder.txtCountry.setText(item.getSys().getCountry());
        weatherViewHolder.txtHumidity.setText(item.getTemperature().getHumidity());
       // weatherViewHolder.txtWay.setText(item.getTemperature().);
        weatherViewHolder.txtSpeed.setText(String.valueOf(item.getWind().getSpeed()));
        //TODO add str in strings and format
        weatherViewHolder.txtTempMinMax.setText(item.getTemperature().getTempMax() + "/" + item.getTemperature().getTempMin());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public void setData(List<WeatherModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addSingleItem(WeatherModel item, int index){
        data.set(index, item);
        notifyItemChanged(index);
    }

    public void addSingleItem(WeatherModel item){
        data.add(item);
        notifyItemChanged(data.size() - 1);
    }

    public void clearData(){
        data.clear();
        notifyDataSetChanged();
    }



    class WeatherViewHolder extends RecyclerView.ViewHolder {
        TextView txtCity;
        TextView txtCountry;
        TextView txtTemp;
        TextView txtHumidity;
        TextView txtWay;
        TextView txtSpeed;
        TextView txtTempMinMax;
        ImageView icon;

        WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCity = itemView.findViewById(R.id.txt_item_city);
            txtCountry = itemView.findViewById(R.id.txt_item_country);
            txtTemp = itemView.findViewById(R.id.txt_item_temp);
            txtHumidity = itemView.findViewById(R.id.txt_item_humidity);
            txtWay = itemView.findViewById(R.id.txt_item_wind);
            txtSpeed = itemView.findViewById(R.id.txt_item_speed);
            txtTempMinMax = itemView.findViewById(R.id.txt_item_temp_min_max);
            icon = itemView.findViewById(R.id.img_item_icon);

        }

    }
}
