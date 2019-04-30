package com.example.lenovo.zhangbaoming.server;

import com.example.lenovo.zhangbaoming.bean.TabBean;
import com.example.lenovo.zhangbaoming.bean.VpBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiServer {
    String tab = "http://www.wanandroid.com/";
    @GET("project/tree/json")
    Observable<TabBean> gettab();
//http://www.wanandroid.com/

    @GET("project/list/1/json?")
    Observable<VpBean> getVp(@Query("cid") int id);
}
