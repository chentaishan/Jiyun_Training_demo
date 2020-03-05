package com.example.jiyun_training_demo.contract;

import com.example.jiyun_training_demo.base.IBasePresenter;
import com.example.jiyun_training_demo.base.IBaseView;
import com.example.jiyun_training_demo.bean.ComonResult;

public interface IRegisterContract {

    interface View<T> extends IBaseView {

        void updateUISuccess(ComonResult<T> results);
        void updateUIFailed(String msg);

    }

    interface Presenter extends IBasePresenter<IRegisterContract.View> {

        void registerInfo(String name, String psw);
    }
}
