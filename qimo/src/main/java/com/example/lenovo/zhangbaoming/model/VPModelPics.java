package com.example.lenovo.zhangbaoming.model;

import com.example.lenovo.zhangbaoming.bean.VpBean;
import com.example.lenovo.zhangbaoming.callback.VpBack;
import com.example.lenovo.zhangbaoming.server.ApiServer;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class VPModelPics implements VpModel{
    @Override
    public void getVp(int path,final VpBack back) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiServer.tab)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiServer server = retrofit.create(ApiServer.class);
        Observable<VpBean> vp = server.getVp(path);
        vp.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VpBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VpBean bean) {
                        if (bean!= null){
                            back.onSucces(bean);
                        }else {
                            back.onFails("失败");
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
