package com.example.jiyun_training_demo.presenter;

import com.example.jiyun_training_demo.base.BasePresenter;
import com.example.jiyun_training_demo.base.IBasePresenter;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.RegisterBean;
import com.example.jiyun_training_demo.contract.IRegisterContract;
import com.example.jiyun_training_demo.service.HomeService;
import com.example.jiyun_training_demo.service.HttpManager;
import com.example.jiyun_training_demo.utils.RxUtils;

import io.reactivex.subscribers.ResourceSubscriber;

public class RegisterPresenter extends BasePresenter<IRegisterContract.View> implements IRegisterContract.Presenter  {


    @Override
    public void registerInfo(String name, String psw) {
        HomeService homeService = HttpManager.getInstance().getRetrofit(HomeService.baseUrl).create(HomeService.class);
        ResourceSubscriber<ComonResult<RegisterBean>> resourceSubscriber = homeService.registerInfo(name, psw)
                .compose(RxUtils.<ComonResult<RegisterBean>>rxScheduler())
                .subscribeWith(new ResourceSubscriber<ComonResult<RegisterBean>>() {
                    @Override
                    public void onNext(ComonResult<RegisterBean> registerBeanComonResult) {

                        view.updateUISuccess(registerBeanComonResult);
                    }

                    @Override
                    public void onError(Throwable t) {

                        view.updateUIFailed(t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        addSubscribe(resourceSubscriber);
    }
}
