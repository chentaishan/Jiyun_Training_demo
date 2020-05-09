package com.example.jiyun_training_demo.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    protected V view;
    private WeakReference<V> vWeakReference;


    //rxjava2被压式处理内存
    CompositeDisposable compositeDisposable;

    /**
     * 使用弱引用加载view,避免内存泄漏
     *
     * @param baseView
     */
    @Override
    public void attachView(V baseView) {

        vWeakReference = new WeakReference<>(baseView);
        view = vWeakReference.get();
    }

    @Override
    public void detachView() {

        if (view != null) {
            view = null;
        }
        if (compositeDisposable != null) {

            compositeDisposable.dispose();
        }

    }

    /**
     *
     * @param disposable
     */
    public void addSubscribe(Disposable disposable) {

        if (compositeDisposable == null) {

            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);

    }
}
