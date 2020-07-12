package com.example.day5_lianxi.callback;

import com.example.day5_lianxi.bean.MyBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {

    String url="http://c.m.163.com/";
    @GET("nc/article/headline/T1348647909107/0-20.html")
    Observable<MyBean> getData();
}
