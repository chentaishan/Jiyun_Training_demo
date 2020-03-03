package com.example.jiyun_training_demo.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.jiyun_training_demo.R;
import com.example.jiyun_training_demo.base.BaseFragment;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.HomeBean;
import com.example.jiyun_training_demo.presenter.HomePresenter;

public class HomeFragment  extends BaseFragment<HomePresenter, HomeBean> {


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

    private static final String TAG = "HomeFragment";


    @Override
    public void updateUIFailed() {

    }
}
