package com.example.domain.respository;

import com.example.domain.model.Weather;

import io.reactivex.Observable;

/**
 * Created by tinyfight on 2018/3/26.
 */

public interface ApplicationRepository {

    Observable<Weather> getWeather(String cityId);

    Observable<String> getTownId(String cityName);

}
