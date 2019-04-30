package com.example.muqier.qimo.persenter;

import com.example.muqier.qimo.bean.TabBean;
import com.example.muqier.qimo.bean.VpBean;
import com.example.muqier.qimo.callback.CallBack;
import com.example.muqier.qimo.mainview.MainView;
import com.example.muqier.qimo.model.MainModel;

public class MainPersentermpl implements MainPersenter,CallBack {
    private MainModel mainModel;
    private MainView mainView;

    public MainPersentermpl(MainModel mainModel, MainView mainView) {
        this.mainModel = mainModel;
        this.mainView = mainView;
    }

    @Override
    public void onSuccess(TabBean tabBean) {
            mainView.onSuccess(tabBean);
    }

    @Override
    public void onFeil(String str) {
        mainView.onFeil(str);
    }

    @Override
    public void onSuccesss(VpBean vpBean) {
        mainView.onSuccesss(vpBean);
    }

    @Override
    public void onFeill(String str) {
        mainView.onFeill(str);
    }

    @Override
    public void getData() {
        mainModel.getData(this);
    }

    @Override
    public void getData1() {
        mainModel.getData1(this);
    }


}
