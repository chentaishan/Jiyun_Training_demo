package com.example.jiyun_training_demo.base;

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    protected V view;


    @Override
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
