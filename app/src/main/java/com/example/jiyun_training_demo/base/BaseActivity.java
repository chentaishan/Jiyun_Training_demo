package com.example.jiyun_training_demo.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//import butterknife.ButterKnife;
//import butterknife.Unbinder;

/**
 * activity 基类
 * 抽取公共P
 * 初始化view
 * 初始化prensenter
 *
 * @param <P>
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    protected P presenter;
//    Unbinder bind;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();

//       bind = ButterKnife.bind(this);
        presenter = initPresenter();

        if (presenter != null) {
            presenter.attachView(this);
        }

    }

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract int getLayout();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView( );
        }

//        if (bind != null) {
//            bind.unbind( );
//        }
    }
}
