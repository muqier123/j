package com.example.zhoumo.model;

import com.example.zhoumo.api.MyServer;
import com.example.zhoumo.base.BaseMode;
import com.example.zhoumo.bean.DaoBean;
import com.example.zhoumo.net.BaseObserver;
import com.example.zhoumo.net.ResultCallBack;
import com.example.zhoumo.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DaoM extends BaseMode {
    public void getData(final ResultCallBack<DaoBean> resultCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyServer.Daomu)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<DaoBean> data2 = myServer.getData2();
        data2.compose(RxUtils.<DaoBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<DaoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(DaoBean daoBean) {
                        resultCallBack.onSuccess(daoBean);
                    }
                });
    }
}
