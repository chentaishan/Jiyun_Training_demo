package com.example.jiyun_training_demo.presenter;

public abstract class BasePresenter<V> implements IBasePresenter {

    protected V view;



    public void attachView(V baseView) {
        view = baseView;
    }

    @Override
    public void detachView() {

        if (view!=null){
            view = null;
        }
    }
}
