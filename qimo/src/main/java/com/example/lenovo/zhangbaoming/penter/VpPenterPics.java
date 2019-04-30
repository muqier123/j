package com.example.lenovo.zhangbaoming.penter;

import com.example.lenovo.zhangbaoming.bean.VpBean;
import com.example.lenovo.zhangbaoming.callback.VpBack;
import com.example.lenovo.zhangbaoming.model.VpModel;
import com.example.lenovo.zhangbaoming.view.VpView;

public class VpPenterPics implements VpPenter, VpBack {
    private VpModel model;
    private VpView view;

    public VpPenterPics(VpModel model, VpView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void VpP(int path) {
        if (model!= null){
            model.getVp(path,this);
        }
    }

    @Override
    public void onSucces(VpBean bean) {
        if (view!= null){
            view.onSucces(bean);
        }
    }

    @Override
    public void onFails(String s) {
if (view!= null){
    view.onFails(s);
}
    }
}
