package com.example.jiyun_training_demo.service;

import com.example.jiyun_training_demo.base.MyApp;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {
    private static HttpManager httpManager;

    private HttpManager() {
    }

    public static HttpManager getInstance() {

        if (httpManager == null) {

            synchronized (HttpManager.class) {

                if (httpManager == null) {
                    httpManager = new HttpManager();
                }
            }
        }

        return httpManager;
    }

    public Retrofit getRetrofit(String url) {

        return new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()
        ).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient())
                .build();

    }

    public OkHttpClient okHttpClient() {

        final OkHttpClient build = new OkHttpClient.Builder()
                .cache(new Cache(MyApp.myApp.getCacheDir(), 10 * 1024 * 1024))
                .build();

        return build;
    }
}
