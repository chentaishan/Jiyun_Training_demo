package com.example.jiyun_training_demo.presenter;

import com.example.jiyun_training_demo.base.BasePresenter;
import com.example.jiyun_training_demo.base.IBasePresenter;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.HomeBean;
import com.example.jiyun_training_demo.bean.LoginBean;
import com.example.jiyun_training_demo.bean.TopicBean;
import com.example.jiyun_training_demo.contract.ILoginContract;
import com.example.jiyun_training_demo.service.HomeService;
import com.example.jiyun_training_demo.service.HttpManager;
import com.example.jiyun_training_demo.utils.CallBackSubscriber;
import com.example.jiyun_training_demo.utils.RxUtils;
import com.example.jiyun_training_demo.utils.SpUtils;

import io.reactivex.subscribers.ResourceSubscriber;

public class LoginPresenter extends BasePresenter<ILoginContract.View> implements ILoginContract.Presenter {

    @Override
    public void loginIn(String name, String psw) {


        ResourceSubscriber<ComonResult<LoginBean>> resourceSubscriber = HttpManager.getInstance().getRetrofit(HomeService.baseUrl)
                .create(HomeService.class)
                .login(name, psw)
                .compose(RxUtils.<ComonResult<LoginBean>>rxScheduler())
                .subscribeWith(new ResourceSubscriber<ComonResult<LoginBean>>() {
                    @Override
                    public void onNext(ComonResult<LoginBean> loginBeanComonResult) {
                        if (loginBeanComonResult.getErrno() == 0) {
                            view.updateUISuccess(loginBeanComonResult);
                            SpUtils.getInstance().setValue("token",loginBeanComonResult.getData().getToken());
                        } else {
                            view.updateUIFailed(loginBeanComonResult.getErrmsg());
                        }
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
