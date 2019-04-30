package com.example.muqier.qimo.api;

import com.example.muqier.qimo.bean.TabBean;
import com.example.muqier.qimo.bean.VpBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyServer {

    public String Utl="http://www.wanandroid.com/project/";
    @GET("tree/json")
    Observable<TabBean>getData();

    public String Uti="http://www.wanandroid.com/project/list/";
    @GET("1/json?cid=294")
    Observable<VpBean>getData1();
}
