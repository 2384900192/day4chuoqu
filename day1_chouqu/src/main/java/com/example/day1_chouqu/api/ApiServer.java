package com.example.day1_chouqu.api;

import com.example.day1_chouqu.bean.MyBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
    String url="http://gank.io/api/";
    @GET("data/%E7%A6%8F%E5%88%A9/20/3")
    Observable<MyBean> getData();
}
