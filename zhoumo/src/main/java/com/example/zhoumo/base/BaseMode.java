package com.example.zhoumo.base;

import io.reactivex.disposables.CompositeDisposable;

public class BaseMode {
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    public void onDestory() {
        mCompositeDisposable.clear();
    }
}
