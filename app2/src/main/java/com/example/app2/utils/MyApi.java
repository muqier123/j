package com.example.app2.utils;

import com.example.app2.bean.ABean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MyApi {
    //http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1
    String URL = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/";
    @GET
    Observable<ABean> aCall(@Url String s);
}
