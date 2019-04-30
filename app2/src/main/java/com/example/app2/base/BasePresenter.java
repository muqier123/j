package com.example.app2.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView> {
    protected V mView;
    protected ArrayList<BaseModel> mModels = new ArrayList<>();
    public BasePresenter(){
        initModel();
    }
    protected abstract void initModel();
    public void bind(V view){
        this.mView = view;
    }
    public void onDestory() {
        mView = null;
        if (mModels.size()>0){
            for (BaseModel model : mModels) {
                model.onDestory();
            }
        }
    }

}
