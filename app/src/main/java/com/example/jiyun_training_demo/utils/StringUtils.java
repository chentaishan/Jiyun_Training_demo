package com.example.jiyun_training_demo.utils;

public class StringUtils {
    public static String filterStr(float num){
        if (num==0.0f){

            return "0";
        }
        return (num/1)+"";
    }
}
