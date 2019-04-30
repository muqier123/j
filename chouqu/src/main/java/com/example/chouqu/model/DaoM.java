package com.example.chouqu.model;

import com.example.chouqu.base.BaseMode;
import com.example.chouqu.bean.DaoBean;
import com.example.chouqu.net.BaseObserver;
import com.example.chouqu.net.MyServer;
import com.example.chouqu.net.ResultCallBack;
import com.example.chouqu.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DaoM extends BaseMode {
    public void getData(final ResultCallBack<DaoBean> resultCallBack) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(MyServer.Daomu)
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
