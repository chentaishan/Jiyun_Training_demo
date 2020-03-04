package com.example.jiyun_training_demo.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;


import com.example.jiyun_training_demo.R;
import com.example.jiyun_training_demo.base.BaseFragment;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.HomeBean;
import com.example.jiyun_training_demo.contract.HomeContract;
import com.example.jiyun_training_demo.presenter.HomePresenter;

public class HomeFragment  extends BaseFragment<HomePresenter>  implements HomeContract.View {


    @Override
    protected void initData() {

        presenter.getHomeData();
    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getlayout() {
        return R.layout.home_fragment;
    }

    @Override
    public void showTips(String msg) {

    }

    @Override
    public void updateUISuccess(ComonResult results) {

        Log.d(TAG, "updateUISuccess: "+results.getData().toString());
    }

    @Override
    public void updateUIFailed(String msg) {

    }

    private static final String TAG = "HomeFragment";



}
