package com.example.jiyun_training_demo.presenter;

import com.example.jiyun_training_demo.base.BasePresenter;
import com.example.jiyun_training_demo.bean.CartBean;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.DetailsBean;
import com.example.jiyun_training_demo.contract.CartContract;
import com.example.jiyun_training_demo.service.HomeService;
import com.example.jiyun_training_demo.service.HttpManager;
import com.example.jiyun_training_demo.utils.RxUtils;

import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;

public class CartPresenter extends BasePresenter<CartContract.View> implements CartContract.Presenter {
    @Override
    public void getCartDataList() {
        final Retrofit retrofit = HttpManager.getInstance().getRetrofit(HomeService.baseUrl);

        ResourceSubscriber<ComonResult<CartBean>> resourceSubscriber = retrofit.create(HomeService.class).getCartDataList()

                .compose(RxUtils.<ComonResult<CartBean>>rxScheduler())
                .subscribeWith(new ResourceSubscriber<ComonResult<CartBean>>() {
                    @Override
                    public void onNext(ComonResult<CartBean> homeBean) {

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
