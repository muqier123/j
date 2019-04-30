package com.example.chouqu.net;

import com.example.chouqu.bean.DaoBean;
import com.example.chouqu.bean.Fuli;
import com.example.chouqu.bean.ShujuBean;
import com.example.chouqu.bean.VpBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyServer {

    public String Uti="http://www.wanandroid.com/project/list/";
    @GET("1/json?cid=294")
    Observable<VpBean>getData1();

    public String fuli= "http://gank.io/api/data/";
    @GET("%E7%A6%8F%E5%88%A9/20/1")
    Observable<Fuli>getData();

    public String Daomu="https://www.apiopen.top/";
    @GET("novelInfoApi?name=盗墓笔记")
    Observable<DaoBean>getData2();

    public String Shuju="https://api.apiopen.top/";
    @GET("getJoke?page=1&count=2&type=video")
    Observable<ShujuBean>getData3();


}
