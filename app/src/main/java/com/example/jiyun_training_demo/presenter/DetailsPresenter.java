package com.example.jiyun_training_demo.presenter;

import com.example.jiyun_training_demo.base.BasePresenter;
import com.example.jiyun_training_demo.base.IBasePresenter;
import com.example.jiyun_training_demo.bean.AddCartBean;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.DetailsBean;
import com.example.jiyun_training_demo.bean.HomeBean;
import com.example.jiyun_training_demo.contract.IDetailsGoodsContract;
import com.example.jiyun_training_demo.service.HomeService;
import com.example.jiyun_training_demo.service.HttpManager;
import com.example.jiyun_training_demo.utils.RxUtils;
import com.example.jiyun_training_demo.utils.SpUtils;

import java.util.HashMap;

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

    @Override
    public void addGoodsToCart( String goodsId, String number, String productId) {
        final Retrofit retrofit = HttpManager.getInstance().getRetrofit(HomeService.baseUrl);

        String token = SpUtils.getInstance().getString("token");
        HashMap<String,String>  params = new HashMap<>();
        params.put("goodsId",goodsId);
        params.put("number",number);
        params.put("productId",productId);
        ResourceSubscriber<ComonResult<AddCartBean>> resourceSubscriber = retrofit.create(HomeService.class).addGoodsToCart(token,params)

                .compose(RxUtils.<ComonResult<AddCartBean>>rxScheduler())
                .subscribeWith(new ResourceSubscriber<ComonResult<AddCartBean>>() {
                    @Override
                    public void onNext(ComonResult<AddCartBean> addCartBean) {

                        view.addCartSuccess(addCartBean);
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
