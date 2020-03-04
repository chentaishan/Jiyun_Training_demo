package com.example.jiyun_training_demo.presenter;

import com.example.jiyun_training_demo.base.BasePresenter;
import com.example.jiyun_training_demo.base.IBaseView;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.HomeBean;
import com.example.jiyun_training_demo.bean.TopicBean;
import com.example.jiyun_training_demo.contract.TopicContract;
import com.example.jiyun_training_demo.service.HomeService;
import com.example.jiyun_training_demo.service.HttpManager;
import com.example.jiyun_training_demo.ui.dashboard.TopicFragment;
import com.example.jiyun_training_demo.utils.RxUtils;

import io.reactivex.Flowable;
import io.reactivex.subscribers.ResourceSubscriber;

public class TopicPresenter  extends BasePresenter<TopicContract.View> implements TopicContract.Presenter {


    @Override
    public void getTopicData() {

        HomeService homeService = HttpManager.getInstance().getRetrofit(HomeService.baseUrl).create(HomeService.class);

        Flowable<ComonResult<TopicBean>> topicBean = homeService.getTopicBean();

        topicBean .compose(RxUtils.<ComonResult<TopicBean>>rxScheduler())
                .subscribeWith(new ResourceSubscriber<ComonResult<TopicBean>>() {
                    @Override
                    public void onNext(ComonResult<TopicBean> homeBean) {
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


    }


}
