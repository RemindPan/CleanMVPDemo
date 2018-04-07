package com.example.data.net;

import com.example.data.entity.WeatherEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tinyfight on 2018/4/2.
 */

public interface WeatherApi {

    @GET
    Observable<WeatherEntity> getWeather(@Query("city") String cityId);

}
