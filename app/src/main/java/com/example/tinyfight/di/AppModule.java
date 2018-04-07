package com.example.tinyfight.di;

import android.content.Context;

import com.example.data.config.AppTestWeatherConfig;
import com.example.data.config.WeatherConfig;
import com.example.data.executor.JobExecutor;
import com.example.data.net.WeatherApi;
import com.example.data.net.WeatherClient;
import com.example.data.repository.ApplicationDataRepository;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.respository.ApplicationRepository;
import com.example.tinyfight.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tinyfight on 2018/4/4.
 */

@Module
public class AppModule {
    private Context mContext;

    public AppModule(Context context){
        mContext = context;
    }

    @Singleton
    @Provides
    Context provideContext(){
        return mContext;
    }

    @Singleton
    @Provides
    WeatherApi provideWeatherApi(WeatherClient client){
        return client.getApi();
    }

    @Singleton
    @Provides
    WeatherConfig provideConfig(){
        return new AppTestWeatherConfig();
    }

    @Singleton
    @Provides
    ApplicationRepository provideRepository(WeatherApi api){
        return new ApplicationDataRepository(mContext,api);
    }

    @Provides
    @Singleton
    PostExecutionThread providePostInteractionThread(UIThread uiThread) {
        return uiThread;
    }

    @Singleton
    @Provides
    ThreadExecutor provideThreadExecutor(JobExecutor executor){
        return executor;
    }
}
