package com.example.jiyun_training_demo.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.jiyun_training_demo.base.BaseFragment;
import com.example.jiyun_training_demo.base.IBasePresenter;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.TopicBean;
import com.example.jiyun_training_demo.contract.TopicContract;
import com.example.jiyun_training_demo.presenter.TopicPresenter;

public class TopicFragment extends BaseFragment implements TopicContract.View<TopicBean> {


    @Override
    protected void initData() {

    }

    @Override
    protected TopicPresenter initPresenter() {

        return new TopicPresenter();
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getlayout() {
        return 0;
    }

    @Override
    public void updateUISuccess(ComonResult<TopicBean> result) {

    }

    @Override
    public void updateUIFailed(String msg) {

    }

    @Override
    public void showTips(String msg) {

    }
}
