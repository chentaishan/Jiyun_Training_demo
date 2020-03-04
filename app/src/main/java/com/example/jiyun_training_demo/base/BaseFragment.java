package com.example.jiyun_training_demo.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
//import butterknife.ButterKnife;
//import butterknife.Unbinder;

public abstract class BaseFragment<P extends IBasePresenter> extends Fragment implements IBaseView {


    protected P presenter;
    protected Context context;
//    Unbinder bind;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(getlayout(), container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        bind = ButterKnife.bind(view);
        initView(view);

        presenter = initPresenter();
        if (presenter != null) {

            presenter.attachView(this);
        }

        initData();

    }

    protected abstract void initData();

    protected abstract P initPresenter();


    protected abstract void initView(View view);

    protected abstract int getlayout();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        if (bind != null) {
//            bind.unbind();
//        }
    }
}
