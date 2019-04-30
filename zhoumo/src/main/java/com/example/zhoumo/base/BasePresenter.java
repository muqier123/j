package com.example.zhoumo.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseMvpView> {
    protected V mview;
    protected ArrayList<BaseMode> mModels = new ArrayList<>();

    public void bind(V view) {
        this.mview = view;
    }

    public BasePresenter(){
        initModel();
    }

    protected abstract void initModel();

}
