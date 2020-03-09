package com.example.jiyun_training_demo;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class GoodsDetailsActivity extends AppCompatActivity {

    private WebView mWebview;

//    String content=
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_details);
        initView();
    }

    private void initView() {
        mWebview = (WebView) findViewById(R.id.webview);
        mWebview.loadUrl("file:///android_asset/index.html");
    }
}
