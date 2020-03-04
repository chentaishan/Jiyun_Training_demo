package com.example.jiyun_training_demo.utils;


import com.example.jiyun_training_demo.base.IBaseView;

import io.reactivex.subscribers.ResourceSubscriber;

public abstract class CallBackSubscriber<T> extends ResourceSubscriber<T> {

    IBaseView iBaseView;

    public CallBackSubscriber(IBaseView iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void onNext(T o) {


    }

    @Override
    public void onError(Throwable t) {
        if (null!=t.getMessage()){
            iBaseView.showTips(t.getMessage());
        }
    }

    @Override
    public void onComplete() {

    }
}
