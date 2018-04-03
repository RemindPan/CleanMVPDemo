package com.example.domain.interactor;

import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.respository.ApplicationRepository;

/**
 * Created by tinyfight on 2018/3/26.
 */

public abstract class ApplicationInteractor<T> extends Interactor<T>{

    ApplicationRepository repository;

    public ApplicationInteractor(ApplicationRepository repository, ThreadExecutor executor, PostExecutionThread postExecutionThread) {
        super(executor, postExecutionThread);
        this.repository = repository;
    }

}
