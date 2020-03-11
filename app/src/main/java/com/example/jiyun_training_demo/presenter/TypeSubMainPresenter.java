package com.example.jiyun_training_demo.presenter;

import com.example.jiyun_training_demo.base.BasePresenter;
import com.example.jiyun_training_demo.bean.TypeList2SubItemListBean;
import com.example.jiyun_training_demo.contract.ITypeSubMainContract;
import com.example.jiyun_training_demo.service.HomeService;
import com.example.jiyun_training_demo.service.HttpManager;
import com.example.jiyun_training_demo.utils.CallBackSubscriber;
import com.example.jiyun_training_demo.utils.RxUtils;

import io.reactivex.Flowable;
import io.reactivex.subscribers.ResourceSubscriber;

public class TypeSubMainPresenter extends BasePresenter<ITypeSubMainContract.View> implements ITypeSubMainContract.Presenter  {


    @Override
    public void getType2ItemList(String id) {
        HomeService homeService = HttpManager.getInstance().getRetrofit(HomeService.baseUrl).create(HomeService.class);

        Flowable<TypeList2SubItemListBean> topicBean = homeService.getType2ItemList(id);

        ResourceSubscriber<TypeList2SubItemListBean> resourceSubscriber = topicBean.compose(RxUtils.<TypeList2SubItemListBean>rxScheduler())
                .subscribeWith(new CallBackSubscriber<TypeList2SubItemListBean>(view){

                    @Override
                    public void onNext(TypeList2SubItemListBean typeList2SubItemListBean) {
                        super.onNext(typeList2SubItemListBean);

                        view.updateUISuccess(typeList2SubItemListBean);
                    }
                });

        addSubscribe(resourceSubscriber);
    }
}
