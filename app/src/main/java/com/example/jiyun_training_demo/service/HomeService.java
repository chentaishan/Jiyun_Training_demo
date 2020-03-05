package com.example.jiyun_training_demo.service;

import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.HomeBean;
import com.example.jiyun_training_demo.bean.LoginBean;
import com.example.jiyun_training_demo.bean.TopicBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface HomeService {

    String baseUrl="https://cdwan.cn/api/";

    @GET("index")
    Flowable<ComonResult<HomeBean>> getHome();

    @GET("topic/list")
    Flowable<ComonResult<TopicBean>> getTopicBean();


    @FormUrlEncoded
    @POST("auth/login")
    Flowable<ComonResult<LoginBean>> login(@Field("nickname") String name, @Field("password") String password);


}
