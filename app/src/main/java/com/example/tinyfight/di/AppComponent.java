package com.example.tinyfight.di;

import android.app.Application;
import android.content.Context;

import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.respository.ApplicationRepository;
import com.example.tinyfight.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by tinyfight on 2018/4/4.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(Application application);

    ApplicationRepository provideRepository();

    PostExecutionThread providePostInteractionThread();

    ThreadExecutor provideThreadExecutor();
}
