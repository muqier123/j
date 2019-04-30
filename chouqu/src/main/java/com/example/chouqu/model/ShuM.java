package com.example.chouqu.model;

import com.example.chouqu.base.BaseMode;
import com.example.chouqu.bean.DaoBean;
import com.example.chouqu.bean.ShujuBean;
import com.example.chouqu.net.BaseObserver;
import com.example.chouqu.net.MyServer;
import com.example.chouqu.net.ResultCallBack;
import com.example.chouqu.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShuM extends BaseMode {
    public void getData(final ResultCallBack<ShujuBean> resultCallBack) {
        Retrofit build = new Retrofit.Builder().baseUrl(MyServer.Shuju)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyServer myServer = build.create(MyServer.class);
        Observable<ShujuBean> data3 = myServer.getData3();
        data3.compose(RxUtils.<ShujuBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<ShujuBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ShujuBean shujuBean) {
                        resultCallBack.onSuccess(shujuBean);
                    }
                });

    }
}
