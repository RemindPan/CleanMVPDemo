package com.example.tinyfight.di;

import android.app.Activity;

import com.example.tinyfight.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tinyfight on 2018/4/7.
 */
@PerActivity
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {
    Activity provideActivity();
    void inject(MainActivity activity);
}
