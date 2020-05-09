package com.example.jiyun_training_demo.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BasePresenterFragment<P extends IBasePresenter> extends BaseFragment  {


    protected P presenter;


    @Override
    protected void initView(View view) {
        super.initView(view);


        presenter = initPresenter();
        if (presenter != null) {

            presenter.attachView(this);
        }


    }



    protected abstract void initData();

    protected abstract P initPresenter();


    protected abstract int getlayout();

}
