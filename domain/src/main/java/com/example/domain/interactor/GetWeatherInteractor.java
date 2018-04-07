package com.example.domain.interactor;

import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.model.Weather;
import com.example.domain.respository.ApplicationRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by tinyfight on 2018/4/2.
 */

public class GetWeatherInteractor extends ApplicationInteractor<Weather> {

    String townId;

    @Inject
    public GetWeatherInteractor(ApplicationRepository repository, ThreadExecutor executor, PostExecutionThread postExecutionThread) {
        super(repository, executor, postExecutionThread);
    }

    public void seTownId(String townId){
        this.townId = townId;
    }

    @Override
    protected Observable<Weather> buildObservable() {
        return repository.getWeather(townId);
    }
}
