package com.example.jiyun_training_demo.contract;

import com.example.jiyun_training_demo.base.IBasePresenter;
import com.example.jiyun_training_demo.base.IBaseView;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.TopicBean;

public interface TopicContract {

    interface View<T> extends IBaseView {

        void updateUISuccess(ComonResult<T> result);
        void updateUIFailed(String msg);
    }

    interface Presenter extends IBasePresenter<View> {

       void getTopicData();
    }
}
