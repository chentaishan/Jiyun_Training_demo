package com.example.jiyun_training_demo.presenter;

import com.example.jiyun_training_demo.base.BasePresenter;
import com.example.jiyun_training_demo.base.IBasePresenter;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.DetailsBean;
import com.example.jiyun_training_demo.bean.HomeBean;
import com.example.jiyun_training_demo.contract.IDetailsGoodsContract;
import com.example.jiyun_training_demo.service.HomeService;
import com.example.jiyun_training_demo.service.HttpManager;
import com.example.jiyun_training_demo.utils.RxUtils;

import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;

public class DetailsPresenter extends BasePresenter<IDetailsGoodsContract.View> implements IDetailsGoodsContract.Presenter {


    @Override
    public void getDetailsBean(String id) {

        final Retrofit retrofit = HttpManager.getInstance().getRetrofit(HomeService.baseUrl);

        ResourceSubscriber<ComonResult<DetailsBean>> resourceSubscriber = retrofit.create(HomeService.class).getDetails(id)

                .compose(RxUtils.<ComonResult<DetailsBean>>rxScheduler())
                .subscribeWith(new ResourceSubscriber<ComonResult<DetailsBean>>() {
                    @Override
                    public void onNext(ComonResult<DetailsBean> homeBean) {

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
