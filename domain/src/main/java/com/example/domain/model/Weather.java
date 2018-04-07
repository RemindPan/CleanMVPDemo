package com.example.domain.model;

import java.util.List;

/**
 * Created by tinyfight on 2018/4/2.
 *
 * app展示所需业务数据.
 */

public class Weather {

    /**
     * status : OK
     * weather : [{"city_name":"佛山","city_id":"CHGD070000","last_update":"2017-02-19T12:15:00+08:00","now":{"text":"阴","code":"9","temperature":"21","feels_like":"21","wind_direction":"南","wind_speed":"10.44","wind_scale":"2","humidity":"58","visibility":"13.8","pressure":"1014","pressure_rising":"未知","air_quality":{"city":{"aqi":"64","pm25":"46","pm10":"74","so2":"9","no2":"28","co":"0.575","o3":"108","last_update":"2017-02-19T12:00:00+08:00","quality":"良"},"stations":null}},"today":{"sunrise":"06:58 AM","sunset":"6:27 PM","suggestion":{"dressing":{"brief":"单衣类","details":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。"},"uv":{"brief":"最弱","details":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"},"car_washing":{"brief":"不适宜","details":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"},"travel":{"brief":"适宜","details":"天气较好，温度适宜，总体来说还是好天气哦，这样的天气适宜旅游，您可以尽情地享受大自然的风光。"},"flu":{"brief":"易发期","details":"相对今天出现了较大幅度降温，较易发生感冒，体质较弱的朋友请注意适当防护。"},"sport":{"brief":"比较适宜","details":"阴天，较适宜进行各种户内外运动。"}}},"future":[{"date":"2017-02-19","day":"周日","text":"阴/小雨","code1":"9","code2":"13","high":"24","low":"18","cop":"","wind":"微风3级"},{"date":"2017-02-20","day":"周一","text":"阴","code1":"9","code2":"9","high":"23","low":"18","cop":"","wind":"微风3级"},{"date":"2017-02-21","day":"周二","text":"阵雨","code1":"10","code2":"10","high":"22","low":"18","cop":"","wind":"微风3级"},{"date":"2017-02-22","day":"周三","text":"小雨","code1":"13","code2":"13","high":"23","low":"13","cop":"","wind":"微风3级"},{"date":"2017-02-23","day":"周四","text":"小雨","code1":"13","code2":"13","high":"20","low":"10","cop":"","wind":"北风4级"},{"date":"2017-02-24","day":"周五","text":"小雨","code1":"13","code2":"13","high":"14","low":"10","cop":"","wind":"北风4级"},{"date":"2017-02-25","day":"周六","text":"小雨","code1":"13","code2":"13","high":"15","low":"10","cop":"","wind":"微风3级"},{"date":"2017-02-26","day":"周日","text":"小雨","code1":"13","code2":"13","high":"15","low":"10","cop":"","wind":"北风3级"},{"date":"2017-02-27","day":"周一","text":"小雨/多云","code1":"13","code2":"4","high":"21","low":"11","cop":"","wind":"北风3级"},{"date":"2017-02-28","day":"周二","text":"多云","code1":"4","code2":"4","high":"24","low":"14","cop":"","wind":"北风3级"}]}]
     */

    private String cityName;
    private String cityId;
    private String lastUpdate;


    private String nowText;
    private String nowCode;
    private String nowTemperature;
    private String nowFeelsLike;
    private String nowWindDirection;
    private String nowWindSpeed;


    private String todaySunrise;
    private String todaySunset;
    private String todayUvSuggestionBrief;
    private String todayUvSuggestionDetail;
    private String todayDressSuggestionBrief;
    private String todayDressSuggestionDetail;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getNowText() {
        return nowText;
    }

    public void setNowText(String nowText) {
        this.nowText = nowText;
    }

    public String getNowTemperature() {
        return nowTemperature;
    }

    public void setNowTemperature(String nowTemperature) {
        this.nowTemperature = nowTemperature;
    }

    public String getNowWindDirection() {
        return nowWindDirection;
    }

    public void setNowWindDirection(String nowWindDirection) {
        this.nowWindDirection = nowWindDirection;
    }

    public String getNowCode() {
        return nowCode;
    }

    public void setNowCode(String nowCode) {
        this.nowCode = nowCode;
    }

    public String getNowFeelsLike() {
        return nowFeelsLike;
    }

    public void setNowFeelsLike(String nowFeelsLike) {
        this.nowFeelsLike = nowFeelsLike;
    }

    public String getNowWindSpeed() {
        return nowWindSpeed;
    }

    public void setNowWindSpeed(String nowWindSpeed) {
        this.nowWindSpeed = nowWindSpeed;
    }

    public String getTodaySunrise() {
        return todaySunrise;
    }

    public void setTodaySunrise(String todaySunrise) {
        this.todaySunrise = todaySunrise;
    }

    public String getTodaySunset() {
        return todaySunset;
    }

    public void setTodaySunset(String todaySunset) {
        this.todaySunset = todaySunset;
    }

    public String getTodayUvSuggestionBrief() {
        return todayUvSuggestionBrief;
    }

    public void setTodayUvSuggestionBrief(String todayUvSuggestionBrief) {
        this.todayUvSuggestionBrief = todayUvSuggestionBrief;
    }

    public String getTodayUvSuggestionDetail() {
        return todayUvSuggestionDetail;
    }

    public void setTodayUvSuggestionDetail(String todayUvSuggestionDetail) {
        this.todayUvSuggestionDetail = todayUvSuggestionDetail;
    }

    public String getTodayDressSuggestionBrief() {
        return todayDressSuggestionBrief;
    }

    public void setTodayDressSuggestionBrief(String todayDressSuggestionBrief) {
        this.todayDressSuggestionBrief = todayDressSuggestionBrief;
    }

    public String getTodayDressSuggestionDetail() {
        return todayDressSuggestionDetail;
    }

    public void setTodayDressSuggestionDetail(String todayDressSuggestionDetail) {
        this.todayDressSuggestionDetail = todayDressSuggestionDetail;
    }
}
