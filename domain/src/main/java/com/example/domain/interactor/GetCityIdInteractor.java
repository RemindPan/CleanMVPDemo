package com.example.domain.interactor;

import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.respository.ApplicationRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by tinyfight on 2018/4/7.
 */

public class GetCityIdInteractor extends ApplicationInteractor<String> {
    private String name;
    @Inject
    public GetCityIdInteractor(ApplicationRepository repository, ThreadExecutor executor, PostExecutionThread postExecutionThread) {
        super(repository, executor, postExecutionThread);
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    protected Observable<String> buildObservable() {
        return repository.getTownId(name);
    }
}
