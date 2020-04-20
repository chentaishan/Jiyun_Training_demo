package com.example.jiyun_training_demo.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BasePresenterActivity<P extends BasePresenter> extends BaseActivity implements IBaseView {

    protected P presenter;

    @Override
    protected void initView() {
        super.initView();

        presenter = initPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    protected abstract P initPresenter( );

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView( );
        }

    }
}
