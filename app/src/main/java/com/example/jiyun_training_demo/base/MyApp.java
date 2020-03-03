package com.example.jiyun_training_demo.base;

import android.app.Application;

public class MyApp extends Application {
    public static MyApp myApp;

    @Override
    public void onCreate() {
        super.onCreate();

        myApp = this;
    }
}
