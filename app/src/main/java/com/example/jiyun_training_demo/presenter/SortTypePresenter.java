package com.example.jiyun_training_demo.presenter;

import com.example.jiyun_training_demo.base.BasePresenter;
import com.example.jiyun_training_demo.base.IBasePresenter;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.SortTypeBean;
import com.example.jiyun_training_demo.bean.SortType_Itembean;
import com.example.jiyun_training_demo.contract.ISortTypeContract;
import com.example.jiyun_training_demo.service.HomeService;
import com.example.jiyun_training_demo.service.HttpManager;
import com.example.jiyun_training_demo.utils.RxUtils;

import io.reactivex.Flowable;
import io.reactivex.subscribers.ResourceSubscriber;

public class SortTypePresenter  extends BasePresenter<ISortTypeContract.View> implements ISortTypeContract.Presenter {


    @Override
    public void getSortTypeList() {
        Flowable<ComonResult<SortTypeBean>> sortTypeList = HttpManager.getInstance().getRetrofit(HomeService.baseUrl)
                .create(HomeService.class)
                .getSortTypeList();

        sortTypeList.compose(RxUtils.<ComonResult<SortTypeBean>>rxScheduler())
                .subscribeWith(new ResourceSubscriber<ComonResult<SortTypeBean>>() {
            @Override
            public void onNext(ComonResult<SortTypeBean> sortTypeBean) {

                view.updateUISuccess(sortTypeBean);
            }

            @Override
            public void onError(Throwable t) {

                view.updateUIFailed(t.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void getTypeList(String id) {
        Flowable<SortType_Itembean> sortTypeList = HttpManager.getInstance().getRetrofit(HomeService.baseUrl)
                .create(HomeService.class)
                .getSortType_ItemList(id);

        sortTypeList.compose(RxUtils.<SortType_Itembean>rxScheduler()).subscribeWith(new ResourceSubscriber<SortType_Itembean>() {
            @Override
            public void onNext(SortType_Itembean sortTypeBean) {

                view.updateSubItem(sortTypeBean);
            }

            @Override
            public void onError(Throwable t) {

                view.updateUIFailed(t.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
