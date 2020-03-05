package com.example.jiyun_training_demo.base;

public interface IBasePresenter<V > {

    void attachView(V baseView);
    void detachView();
}
