package com.example.jiyun_training_demo.presenter;

import com.example.jiyun_training_demo.bean.ComonResult;

public interface IBaseView<T> {


    void showTips(String msg);

    void updateUISuccess(ComonResult<T> results);
    void updateUIFailed();
}
