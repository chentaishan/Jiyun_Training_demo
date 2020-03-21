package com.example.jiyun_training_demo.contract;

import com.example.jiyun_training_demo.base.IBasePresenter;
import com.example.jiyun_training_demo.base.IBaseView;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.LoginBean;

public interface ILoginContract {

    interface View<T> extends IBaseView {

        void updateUISuccess(ComonResult<LoginBean> results);
        void updateUIFailed(String msg);

    }

    interface Presenter extends IBasePresenter<ILoginContract.View> {

        void loginIn(String name,String psw);
    }
}
