package com.example.muqier.qimo.model;

import com.example.muqier.qimo.api.MyServer;
import com.example.muqier.qimo.bean.TabBean;
import com.example.muqier.qimo.bean.VpBean;
import com.example.muqier.qimo.callback.CallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModelmpl implements MainModel{
    @Override
    public void getData(final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyServer.Utl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<TabBean> data = myServer.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TabBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TabBean tabBean) {
                            if (tabBean!=null){
                                callBack.onSuccess(tabBean);

                            }
                    }

                    @Override
                    public void onError(Throwable e) {
                    callBack.onFeil(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getData1( final CallBack callBack) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(MyServer.Uti)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyServer myServer = build.create(MyServer.class);
        Observable<VpBean> data1 = myServer.getData1();
        data1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VpBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                                 }

                    @Override
                    public void onNext(VpBean vpBean) {
                        if (vpBean!=null){
                            callBack.onSuccesss(vpBean);

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    callBack.onFeill(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
