package com.example.jiyun_training_demo.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyun_training_demo.R;
import com.example.jiyun_training_demo.adapter.TopicAdapter;
import com.example.jiyun_training_demo.base.BaseFragment;
import com.example.jiyun_training_demo.base.BasePresenterFragment;
import com.example.jiyun_training_demo.base.IBasePresenter;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.TopicBean;
import com.example.jiyun_training_demo.contract.TopicContract;
import com.example.jiyun_training_demo.presenter.TopicPresenter;

public class TopicFragment  extends BasePresenterFragment<TopicPresenter> implements TopicContract.View<TopicBean> {

    private RecyclerView recyclerView;
    private TopicAdapter topicAdapter;

    @Override
    protected void initData() {

        presenter.getTopicData();
    }

    @Override
    protected TopicPresenter initPresenter() {

        return new TopicPresenter();
    }

    @Override
    protected void initView(View view) {
super.initView(view);
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        topicAdapter = new TopicAdapter(context);
        recyclerView.setAdapter(topicAdapter);
    }

    @Override
    protected int getlayout() {
        return R.layout.topic_fragment;
    }


    @Override
    public void updateUISuccess(ComonResult<TopicBean> result) {
        topicAdapter.addDataList(result.getData().getData());
    }



    @Override
    public void updateUIFailed(String msg) {

    }

    @Override
    public void showTips(String msg) {

    }
}
