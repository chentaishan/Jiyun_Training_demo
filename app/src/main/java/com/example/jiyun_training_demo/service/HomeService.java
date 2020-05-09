package com.example.jiyun_training_demo.service;

import com.example.jiyun_training_demo.bean.AddCartBean;
import com.example.jiyun_training_demo.bean.CartBean;
import com.example.jiyun_training_demo.bean.CataLogItemBean;
import com.example.jiyun_training_demo.bean.CatalogBean;
import com.example.jiyun_training_demo.bean.ComonResult;
import com.example.jiyun_training_demo.bean.DetailsBean;
import com.example.jiyun_training_demo.bean.HomeBean;
import com.example.jiyun_training_demo.bean.LoginBean;
import com.example.jiyun_training_demo.bean.RegisterBean;
import com.example.jiyun_training_demo.bean.SearchBean;
import com.example.jiyun_training_demo.bean.SortTypeBean;
import com.example.jiyun_training_demo.bean.SortType_Itembean;
import com.example.jiyun_training_demo.bean.TopicBean;
import com.example.jiyun_training_demo.bean.TypeList2SubItemListBean;

import java.util.HashMap;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface HomeService {

    String baseUrl = "http://39.96.0.38/api/";

    @GET("index")
    Flowable<ComonResult<HomeBean>> getHome();

    @GET("topic/list")
    Flowable<ComonResult<TopicBean>> getTopicBean();


    @FormUrlEncoded
    @POST("auth/login")
    Flowable<ComonResult<LoginBean>> login(@Field("nickname") String name, @Field("password") String password);


    @FormUrlEncoded
    @POST("auth/register")
    @Headers({"Client-Type:ANDROID"})
    Flowable<ComonResult<RegisterBean>> registerInfo(@Field("nickname") String name, @Field("password") String password);
//    String baseUrl="https://cdwan.cn/api/";


    @GET("catalog/index")
    Flowable<CatalogBean> getLeftDataList();

    @GET("catalog/current?")
    Flowable<CataLogItemBean> getRightDataList(@Query("id") String id);

    //获取各个类型下得列表数据
    @GET("goods/list?")
    Flowable<TypeList2SubItemListBean> getType2ItemList(@Query("categoryId") String id);

    @GET("goods/detail?")
    Flowable<ComonResult<DetailsBean>> getDetails(@Query("id") String id);

    @POST("cart/add")
    @FormUrlEncoded
    Flowable<ComonResult<AddCartBean>> addGoodsToCart(@Header("X-Nideshop-Token") String token, @FieldMap HashMap<String, String> params);

    //    https://cdwan.cn/api/cart/index
    @GET("cart/index")
    Flowable<ComonResult<CartBean>> getCartDataList(@Header("X-Nideshop-Token") String token);




    @GET("goods/list")
    Flowable<SearchBean> getGoodsList(@Query("keyword") String keyword, @Query("page") int page
            , @Query("size") int size, @Query("sort") String sort, @Query("order") String order, @Query("categoryId") int categoryId);

}
