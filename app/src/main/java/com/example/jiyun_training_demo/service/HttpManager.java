package com.example.jiyun_training_demo.service;

import android.util.Log;

import com.example.jiyun_training_demo.base.MyApp;
import com.example.jiyun_training_demo.utils.SystemUtils;

import java.io.IOException;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
                .addInterceptor(new LoggingInterceptor())
                .addNetworkInterceptor(new NetWorkInterceptor())
                .build();

        return build;
    }

    class NetWorkInterceptor implements Interceptor{
        Request request;
        @Override
        public Response intercept(Chain chain) throws IOException {


            if (!SystemUtils.checkNetWork()){

                  request = chain.request();

                request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }

            Response response = chain.proceed(request);
            if (!SystemUtils.checkNetWork()){

                int maxAge=0;
                return  response.newBuilder().removeHeader("Pragma").header("Cache-Control","public ,max-age="+maxAge).build();

            }else{

                int maxTime = 60*60 *24;

              return  response.newBuilder().removeHeader("Pragma").header("Cache-Control","public ,max-age="+maxTime).build();

            }


        }
    }

    /**
     * 日志拦截器
     */
    class LoggingInterceptor implements Interceptor{


        @Override
        public Response intercept(Chain chain) throws IOException {

            long start = System.nanoTime();
            Request request = chain.request();
            Response proceed = chain.proceed(request);
            long end = System.nanoTime();


            Log.i("Request:",String.format("Sending request %s on %s%n%s",request.url(),chain.connection(),request.headers()));

            Log.i("interceptor","time="+(end-start)+"ms");
            return proceed;
        }
    }
}
