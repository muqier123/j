package com.example.lenovo.zhangbaoming.model;

import com.example.lenovo.zhangbaoming.bean.TabBean;
import com.example.lenovo.zhangbaoming.callback.CallBack;
import com.example.lenovo.zhangbaoming.server.ApiServer;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ModelPics implements MainModel{
    @Override
    public void get(final CallBack back) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiServer.tab)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServer server = retrofit.create(ApiServer.class);
        Observable<TabBean> gettab = server.gettab();
        gettab.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TabBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TabBean bean) {
                        if (bean!= null){
                            back.onSucces(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        back.onFails(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
