package com.daily.weather.db.converters;

import android.arch.persistence.room.TypeConverter;

import com.daily.weather.model.Coord;
import com.daily.weather.model.Sys;
import com.daily.weather.model.Weather;
import com.daily.weather.model.Wind;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ReflectionConverter<T > {
    private T instance;
    @TypeConverter
    public String fromT(T type){
        return "";
    }


    private  List<Field> getFields(T t){
        List<Field> privateFields = new ArrayList<>();
        Field[] allFields = t.getClass().getDeclaredFields();
        for (Field field : allFields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(true);
                privateFields.add(field);
            }
        }
        return privateFields;
    }

    private String gg(T t){
        StringBuilder builder = new StringBuilder();
        List<Field> fields = getFields(t);
        for(Field field: fields) {
            try {
                builder.append("/").append(field.getName()).append(":").append(field.get(t));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return builder.toString();
    }


}
