package com.example.jiyun_training_demo.contract;

import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.base.IBasePresenter;
import com.example.jiyun_training_demo.base.IBaseView;

public interface HomeContract  {

    interface View<T> extends IBaseView {

        void updateUISuccess(ComonResult<T> results);
        void updateUIFailed(String msg);

    }

    interface Presenter extends IBasePresenter<View> {

        void getHomeData();
    }
}
