package com.example.chouqu.model;

import com.example.chouqu.base.BaseMode;
import com.example.chouqu.bean.Fuli;
import com.example.chouqu.net.BaseObserver;
import com.example.chouqu.net.HttpUtils;
import com.example.chouqu.net.MyServer;
import com.example.chouqu.net.ResultCallBack;
import com.example.chouqu.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FuLiM extends BaseMode {
    public void getData(final ResultCallBack<Fuli> resultCallBack) {
       // MyServer apiserver = HttpUtils.getInstance().getApiserver(MyServer.fuli, MyServer.class);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(MyServer.fuli)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<Fuli> data = myServer.getData();
        data.compose(RxUtils.<Fuli>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Fuli>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Fuli fuli) {
                        resultCallBack.onSuccess(fuli);
                    }
                });
    }
}
