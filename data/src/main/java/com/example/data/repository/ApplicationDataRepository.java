package com.example.data.repository;

import com.example.data.net.WeatherApi;
import com.example.domain.model.Weather;
import com.example.domain.respository.ApplicationRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by tinyfight on 2018/4/2.
 */

@Singleton
public class ApplicationDataRepository implements ApplicationRepository {
    private static final String TAG = "ApplicationDataRepository";

    private WeatherApi weatherApi;

    @Inject
    public ApplicationDataRepository(WeatherApi webService){
        this.weatherApi = webService;
    }
    @Override
    public Observable<Weather> getWeather(String cityId) {
        return weatherApi.getWeather(cityId);
    }
}
