package com.example.tinyfight;

import android.app.Application;

import com.example.tinyfight.di.AppComponent;
import com.example.tinyfight.di.AppModule;
import com.example.tinyfight.di.DaggerAppComponent;

/**
 * Created by tinyfight on 2018/4/4.
 */

public class WeatherApplication extends Application {
    private AppComponent appCompent;
    private static WeatherApplication sApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        AppModule module = new AppModule(sApp);
        appCompent = DaggerAppComponent.builder().appModule(module).build();
        appCompent.inject(this);
    }
}
