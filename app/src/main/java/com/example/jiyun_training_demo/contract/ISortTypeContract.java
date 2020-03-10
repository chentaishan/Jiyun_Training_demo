package com.example.jiyun_training_demo.contract;

import com.example.jiyun_training_demo.base.IBasePresenter;
import com.example.jiyun_training_demo.base.IBaseView;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.SortType_Itembean;

public interface ISortTypeContract {

    interface View<T> extends IBaseView {

        void updateUISuccess(ComonResult<T>  sortType);
        void updateSubItem(SortType_Itembean sortType);

        void updateUIFailed(String msg);

    }

    interface Presenter extends IBasePresenter<View>{

        void getSortTypeList();

        /**
         * 获取分类下列表数据
         */
        void getTypeList(String id);
    }
}
