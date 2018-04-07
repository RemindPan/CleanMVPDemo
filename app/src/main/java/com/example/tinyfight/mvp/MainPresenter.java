package com.example.tinyfight.mvp;

import com.example.domain.interactor.GetCityIdInteractor;
import com.example.domain.interactor.GetWeatherInteractor;
import com.example.domain.model.Weather;
import com.example.tinyfight.di.PerActivity;
import com.example.tinyfight.mvp.main.MainConstract;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by tinyfight on 2018/4/7.
 */

public class MainPresenter implements MainConstract.Presenter<MainConstract.View> {

    @Inject
    GetWeatherInteractor weatherInteractor;
    @Inject
    GetCityIdInteractor cityInteractor;

    protected MainConstract.View mView;

    @Inject
    MainPresenter(){}

    @Override
    public void attachView(MainConstract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void getWeather(String cityName) {
        cityInteractor.setName(cityName);
        cityInteractor.execute(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                weatherInteractor.setCityId(s);
                weatherInteractor.execute(new Consumer<Weather>() {
                    @Override
                    public void accept(Weather weather) throws Exception {
                        mView.showWeather(weather);
                    }
                });
            }
        });
    }
}
