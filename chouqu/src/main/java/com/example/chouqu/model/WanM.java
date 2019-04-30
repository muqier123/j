package com.example.chouqu.model;

import com.example.chouqu.base.BaseMode;
import com.example.chouqu.bean.VpBean;
import com.example.chouqu.net.BaseObserver;
import com.example.chouqu.net.HttpUtils;
import com.example.chouqu.net.MyServer;
import com.example.chouqu.net.ResultCallBack;
import com.example.chouqu.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WanM extends BaseMode {
    public void getData(final ResultCallBack<VpBean> resultCallBack) {
       /* MyServer apiserver = HttpUtils.getInstance().getApiserver(MyServer.Uti, MyServer.class);*/
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MyServer.Uti)
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<VpBean> data1 = myServer.getData1();
        data1.compose(RxUtils.<VpBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<VpBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(VpBean vpBean) {
                            resultCallBack.onSuccess(vpBean);
                    }
                });

    }
}
