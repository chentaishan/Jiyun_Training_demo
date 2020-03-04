package com.example.jiyun_training_demo.presenter;

import android.util.Log;

import com.example.jiyun_training_demo.base.BasePresenter;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.HomeBean;
import com.example.jiyun_training_demo.contract.HomeContract;
import com.example.jiyun_training_demo.service.HomeService;
import com.example.jiyun_training_demo.service.HttpManager;
import com.example.jiyun_training_demo.ui.home.HomeFragment;
import com.example.jiyun_training_demo.utils.RxUtils;


import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter{


    public void getHomeData(){

        final Retrofit retrofit = HttpManager.getInstance().getRetrofit(HomeService.baseUrl);

        ResourceSubscriber<ComonResult<HomeBean>> resourceSubscriber = retrofit.create(HomeService.class).getHome()

                .compose(RxUtils.<ComonResult<HomeBean>>rxScheduler())
                .subscribeWith(new ResourceSubscriber<ComonResult<HomeBean>>() {
                    @Override
                    public void onNext(ComonResult<HomeBean> homeBean) {
//                        Log.i("onNext:",homeBean.toString());
                        view.updateUISuccess(homeBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        addSubscribe(resourceSubscriber);
    }
}
