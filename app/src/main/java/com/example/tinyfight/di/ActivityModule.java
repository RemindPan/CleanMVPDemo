package com.example.tinyfight.di;

import android.app.Activity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tinyfight on 2018/4/7.
 */

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity){
        this.activity = activity;
    }

    @Provides
   Activity provideActivity(){
        return this.activity;
    }
}
