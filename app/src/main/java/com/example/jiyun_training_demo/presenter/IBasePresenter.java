package com.example.jiyun_training_demo.presenter;

public interface IBasePresenter<V extends IBaseView> {

    void attachView(V baseView);
    void detachView();
}
