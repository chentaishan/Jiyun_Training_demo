package com.example.jiyun_training_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jiyun_training_demo.base.BaseActivity;
import com.example.jiyun_training_demo.base.BasePresenter;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.contract.IRegisterContract;
import com.example.jiyun_training_demo.presenter.RegisterPresenter;

public class RegisterActivity  extends BaseActivity<RegisterPresenter> implements IRegisterContract.View {
    EditText name,psw;
    Button  register;

    @Override
    protected void initData() {

    }

    @Override
    protected RegisterPresenter initPresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected void initView() {
        name = findViewById(R.id.name);
        psw = findViewById(R.id.pass);

        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.registerInfo(name.getText().toString(),psw.getText().toString());
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void updateUISuccess(ComonResult results) {

        Toast.makeText(this, "注册成功！", Toast.LENGTH_SHORT).show();
        finish();
    }

    private static final String TAG = "RegisterActivity";
    @Override
    public void updateUIFailed(String msg) {

        Log.d(TAG, "updateUIFailed: "+msg);
    }

    @Override
    public void showTips(String msg) {

        Log.d(TAG, "showTips: "+msg);
    }
}
