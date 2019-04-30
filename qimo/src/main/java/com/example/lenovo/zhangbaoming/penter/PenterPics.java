package com.example.lenovo.zhangbaoming.penter;

import com.example.lenovo.zhangbaoming.bean.TabBean;
import com.example.lenovo.zhangbaoming.callback.CallBack;
import com.example.lenovo.zhangbaoming.model.MainModel;
import com.example.lenovo.zhangbaoming.view.MainView;

public class PenterPics implements MainPenter, CallBack {
    private MainModel model;
    private MainView view;

    public PenterPics(MainModel model, MainView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void getData() {
        if (model != null) {
            model.get(this);
        }
    }

    @Override
    public void onSucces(TabBean bean) {
        if (view != null) {
            view.onSucces(bean);
        }
    }

    @Override
    public void onFails(String s) {
        if (view != null) {
            view.onFails(s);
        }
    }
}
