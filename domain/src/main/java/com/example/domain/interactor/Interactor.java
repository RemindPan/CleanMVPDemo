package com.example.domain.interactor;

import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tinyfight on 2018/3/26.
 */

/**
 * 该类作为所有业务(user case或interactor)的抽象类
 * 其具体实现类主要负责执行具体的use case。
 * 最终都会调用execute方法在后台执行相应业务，并切换到主线程进行ui更新
 * @param <T>
 */
public abstract class Interactor<T> {
    protected PostExecutionThread postExecutionThread;
    protected ThreadExecutor threadExecutor;
    private Disposable disposable = Disposables.empty();

    Observable<T> observable;

    public Interactor(ThreadExecutor executor, PostExecutionThread postExecutionThread){
        this.threadExecutor = executor;
        this.postExecutionThread = postExecutionThread;
    }

    protected abstract Observable<T> buildObservable();

    public T executeSync(){
        return buildObservable().blockingFirst();
    }

    public void execute(Consumer<T> onNext){
        execute(onNext,null,null);
    }

    public void execute(Consumer<T> onNext,Consumer<Throwable> onError){
        execute(onNext,onError,null);
    }

    public void execute(final Consumer<T> onNext, final Consumer<Throwable> onError, final Action onComplete){
        execute(new Observer<T>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(T value) {
                if (onNext != null && !disposable.isDisposed()) {
                    try {
                        onNext.accept(value);
                    } catch (Exception e) {
                        onError(e);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                if (onError == null || disposable.isDisposed()) {
                    e.printStackTrace();
                } else {
                    try {
                        onError.accept(e);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }

            @Override
            public void onComplete() {
                if (onComplete != null && !disposable.isDisposed()) {
                    try {
                        onComplete.run();
                    } catch (Exception e) {
                        onError(e);
                    }
                }
            }
        });
    }

    private void execute(Observer<T> observer){

        observable = buildObservable();

        cancel();
        observable.subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(observer);
    }

    public void  cancel(){
        if (!disposable.isDisposed()){
            disposable.dispose();
        }
    }

    public Observable<T> getObservable() {
        return observable;
    }
}
