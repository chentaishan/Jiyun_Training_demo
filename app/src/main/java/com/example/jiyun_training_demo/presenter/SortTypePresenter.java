package com.example.jiyun_training_demo.presenter;

import com.example.jiyun_training_demo.base.BasePresenter;
import com.example.jiyun_training_demo.base.IBasePresenter;
import com.example.jiyun_training_demo.bean.CataLogItemBean;
import com.example.jiyun_training_demo.bean.CatalogBean;
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
        Flowable<CatalogBean> sortTypeList = HttpManager.getInstance().getRetrofit(HomeService.baseUrl)
                .create(HomeService.class)
                .getLeftDataList();

        sortTypeList.compose(RxUtils.<CatalogBean>rxScheduler())
                .subscribeWith(new ResourceSubscriber<CatalogBean>() {
            @Override
            public void onNext(CatalogBean sortTypeBean) {

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
        Flowable<CataLogItemBean> sortTypeList = HttpManager.getInstance().getRetrofit(HomeService.baseUrl)
                .create(HomeService.class)
                .getRightDataList(id);

        sortTypeList.compose(RxUtils.<CataLogItemBean>rxScheduler()).subscribeWith(new ResourceSubscriber<CataLogItemBean>() {
            @Override
            public void onNext(CataLogItemBean sortTypeBean) {

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
