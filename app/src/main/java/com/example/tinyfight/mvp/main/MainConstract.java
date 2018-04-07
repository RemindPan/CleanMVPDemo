package com.example.tinyfight.mvp.main;

import com.example.domain.model.Weather;
import com.example.tinyfight.base.IBasePresenter;
import com.example.tinyfight.base.IBaseView;

/**
 * Created by tinyfight on 2018/4/7.
 */

public interface MainConstract {
    interface View extends IBaseView{
        void showWeather(Weather weather);
    }

    interface Presenter<V extends IBaseView> extends IBasePresenter<View>{
        void getWeather(String cityName);
    }
}
