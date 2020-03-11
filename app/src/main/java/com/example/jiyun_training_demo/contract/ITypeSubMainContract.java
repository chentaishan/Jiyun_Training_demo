package com.example.jiyun_training_demo.contract;

import com.example.jiyun_training_demo.base.IBasePresenter;
import com.example.jiyun_training_demo.base.IBaseView;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.TypeList2SubItemListBean;

public interface ITypeSubMainContract {


    interface View<T> extends IBaseView {

        void updateUISuccess(TypeList2SubItemListBean result);
        void updateUIFailed(String msg);
    }

    interface Presenter extends IBasePresenter<View> {

        void getType2ItemList(String id);
    }
}
