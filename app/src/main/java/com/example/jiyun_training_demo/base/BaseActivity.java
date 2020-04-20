package com.example.jiyun_training_demo.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * activity 基类
 *
 *
 */
public abstract class BaseActivity extends AppCompatActivity   {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();

        initData();
    }

    protected void initView() {
    }

    protected abstract void initData();


    protected abstract int getLayout();


}
