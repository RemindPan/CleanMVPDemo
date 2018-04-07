package com.example.tinyfight.base;

/**
 * Created by tinyfight on 2018/4/7.
 */

public interface IBasePresenter<T extends IBaseView> {
    void attachView(T view);

    void detachView();
}
