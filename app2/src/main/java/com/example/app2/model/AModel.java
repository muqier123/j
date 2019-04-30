package com.example.app2.model;

import com.example.app2.base.BaseModel;
import com.example.app2.bean.ABean;
import com.example.app2.utils.CallBacks;
import com.example.app2.utils.MyApi;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AModel extends BaseModel {
    public void getData(String s, final CallBacks<ABean> callBacks) {
        Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(MyApi.URL)
                        .build();
                MyApi myApi = retrofit.create(MyApi.class);
                Observable<ABean> call = myApi.aCall(s);
                call.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ABean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(ABean value) {
                                if (value != null) {
                                    callBacks.chengGong(value);
                                } else {
                                    callBacks.shiBai("失败");
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                callBacks.shiBai(e.getMessage());
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
    }
}
