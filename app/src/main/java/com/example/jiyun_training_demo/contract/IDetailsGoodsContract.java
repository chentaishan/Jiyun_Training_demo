package com.example.jiyun_training_demo.contract;

import com.example.jiyun_training_demo.base.IBasePresenter;
import com.example.jiyun_training_demo.base.IBaseView;
import com.example.jiyun_training_demo.bean.ComonResult;

public interface IDetailsGoodsContract {

    interface View<T> extends IBaseView {

        void updateUISuccess(ComonResult<T> results);
        void addCartSuccess(ComonResult<T> results);
        void updateUIFailed(String msg);

    }

    interface Presenter extends IBasePresenter<IDetailsGoodsContract.View> {

        void getDetailsBean(String id );
        void addGoodsToCart( String goodsId,String number,String productId);
    }
}
