package com.example.jiyun_training_demo.base;

import android.app.Activity;
import android.os.Bundle;

import com.example.jiyun_training_demo.presenter.BasePresenter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity{

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        presenter = initPresenter();

    }

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract int getLayout();
}
