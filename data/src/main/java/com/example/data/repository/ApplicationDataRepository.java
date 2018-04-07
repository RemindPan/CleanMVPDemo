package com.example.data.repository;

import android.content.Context;

import com.example.data.entity.CityEntity;
import com.example.data.entity.WeatherEntity;
import com.example.data.net.WeatherApi;
import com.example.domain.model.Weather;
import com.example.domain.respository.ApplicationRepository;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

/**
 * Created by tinyfight on 2018/4/2.
 */

@Singleton
public class ApplicationDataRepository implements ApplicationRepository {
    private static final String TAG = "ApplicationDataRepository";

    private WeatherApi weatherApi;
    private Context context;
    private ArrayList<CityEntity> cityArrayList;

    @Inject
    public ApplicationDataRepository(Context context, WeatherApi weatherApi){
        this.context = context;
        this.weatherApi = weatherApi;
    }
    @Override
    public Observable<Weather> getWeather(String cityId) {

        Observable<WeatherEntity> sourceObservable = weatherApi.getWeather(cityId);
        Observable<Weather> dest = sourceObservable.map(new Function<WeatherEntity, Weather>() {
            @Override
            public Weather apply(WeatherEntity weatherEntity) throws Exception {
                Weather weather = new Weather();
                if("OK".equals(weatherEntity.getStatus())
                        && weatherEntity.getWeather() != null
                        && weatherEntity.getWeather().size() != 0){
                    weather.setCityId(weatherEntity.getWeather().get(0).getCity_id());
                    weather.setCityName(weatherEntity.getWeather().get(0).getCity_name());
                    weather.setNowText(weatherEntity.getWeather().get(0).getNow().getText());
                    weather.setNowFeelsLike(weatherEntity.getWeather().get(0).getNow().getFeels_like());
                    weather.setNowTemperature(weatherEntity.getWeather().get(0).getNow().getTemperature());
                    weather.setNowWindDirection(weatherEntity.getWeather().get(0).getNow().getWind_direction());
                    weather.setNowWindSpeed(weatherEntity.getWeather().get(0).getNow().getWind_speed());
                    weather.setNowCode(weatherEntity.getWeather().get(0).getNow().getCode());

                    weather.setTodayDressSuggestionBrief(weatherEntity.getWeather().get(0).getToday().getSuggestion().getDressing().getBrief());
                    weather.setTodayDressSuggestionDetail(weatherEntity.getWeather().get(0).getToday().getSuggestion().getDressing().getDetails());
                    weather.setTodayUvSuggestionBrief(weatherEntity.getWeather().get(0).getToday().getSuggestion().getUv().getBrief());
                    weather.setTodayUvSuggestionDetail(weatherEntity.getWeather().get(0).getToday().getSuggestion().getUv().getDetails());
                    weather.setTodaySunrise(weatherEntity.getWeather().get(0).getToday().getSunrise());
                    weather.setTodaySunset(weatherEntity.getWeather().get(0).getToday().getSunset());
                    return weather;
                }

                return null;
            }
        });
        return dest;
    }

    @Override
    public Observable<String> getTownId(final String cityName) {
        Observable<String> dest;
        if(cityArrayList == null){
            dest = Observable.create(new ObservableOnSubscribe<String>() {
                @Override
                public void subscribe(ObservableEmitter<String> e) throws Exception {
                    StringBuilder stringBuilder = new StringBuilder();
                    InputStream inputStream = context.getResources().getAssets().open("cities.json");
                    InputStreamReader isr = new InputStreamReader(inputStream);
                    BufferedReader reader = new BufferedReader(isr);
                    String jsonLine;
                    while ((jsonLine = reader.readLine()) != null) {
                        stringBuilder.append(jsonLine);
                    }
                    reader.close();
                    isr.close();
                    inputStream.close();
                    e.onNext(stringBuilder.toString());
                    e.onComplete();
                }
            }).map(new Function<String, String >() {
                @Override
                public String apply(String s) throws Exception {
                    cityArrayList = new ArrayList<>(4096);
                    JsonArray elements = new JsonParser().parse(s).getAsJsonArray();
                    CityEntity cityEntity;
                    for (int i = 0, size = elements.size(); i < size; i++) {
                        cityEntity = new Gson().fromJson(elements.get(i).getAsJsonObject(), CityEntity.class);
                        cityArrayList.add(cityEntity);
                    }
                    String townId = cityArrayList.get(cityArrayList.indexOf(cityName)).getTownID();
                    return townId;
                }
            });
        } else {
            dest = Observable.create(new ObservableOnSubscribe<String>() {
                @Override
                public void subscribe(ObservableEmitter<String> e) throws Exception {
                    e.onNext(cityArrayList.get(cityArrayList.indexOf(cityName)).getTownID());
                    e.onComplete();
                }
            });
        }
        return dest;
    }
}
