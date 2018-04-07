package com.example.data.config;

/**
 * Created by tinyfight on 2018/4/2.
 */

public class AppTestWeatherConfig implements WeatherConfig {
    @Override
    public String getBaseUrl() {
        return "http://tj.nineton.cn/Heart/index/all/";
    }
}
