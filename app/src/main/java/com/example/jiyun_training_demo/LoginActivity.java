package com.example.jiyun_training_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jiyun_training_demo.base.BaseActivity;
import com.example.jiyun_training_demo.base.BasePresenter;
import com.example.jiyun_training_demo.base.BasePresenterActivity;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.LoginBean;
import com.example.jiyun_training_demo.contract.ILoginContract;
import com.example.jiyun_training_demo.presenter.LoginPresenter;

public class LoginActivity extends BasePresenterActivity<LoginPresenter> implements ILoginContract.View<LoginBean>{


    EditText name,psw;
    Button login,register;

    @Override
    protected void initData() {

    }

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {
        super.initView();

        name = findViewById(R.id.name);
        psw = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loginIn(name.getText().toString(),psw.getText().toString());
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void showTips(String msg) {

        Log.d(TAG, "showTips: "+msg);
    }

    private static final String TAG = "LoginActivity";
    @Override
    public void updateUISuccess(ComonResult<LoginBean> results) {

        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.putExtra("name",results.getData().getUserInfo().getNickname());
        setResult(99,intent);
        finish();
    }

    @Override
    public void updateUIFailed(String msg) {
        Log.d(TAG, "showTips: "+msg);
    }
}
