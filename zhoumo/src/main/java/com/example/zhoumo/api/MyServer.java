package com.example.zhoumo.api;

import com.example.zhoumo.bean.DaoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyServer {
    public String Daomu="https://www.apiopen.top/";
    @GET("novelInfoApi?name=盗墓笔记")
    Observable<DaoBean> getData2();
}
