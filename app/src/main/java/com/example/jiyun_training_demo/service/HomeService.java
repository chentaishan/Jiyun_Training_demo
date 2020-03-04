package com.example.jiyun_training_demo.service;

import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.HomeBean;
import com.example.jiyun_training_demo.bean.TopicBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface HomeService {

    String baseUrl="https://cdwan.cn/api/";

    @GET("index")
    Flowable<ComonResult<HomeBean>> getHome();

    @GET("topic/list")
    Flowable<ComonResult<TopicBean>> getTopicBean();



}
