package com.example.app2.presenter;

import com.example.app2.base.BasePresenter;
import com.example.app2.bean.ABean;
import com.example.app2.model.AModel;
import com.example.app2.utils.CallBacks;
import com.example.app2.view.AView;

public class APresenter extends BasePresenter<AView> {

    private AModel model;

    @Override
    protected void initModel() {

        model = new AModel();
    }

    public void getData(String s) {
        model.getData(s, new CallBacks<ABean>() {
            @Override
            public void chengGong(ABean aBean) {
                if (mView!=null) {
                    mView.setData(aBean);
                }
            }

            @Override
            public void shiBai(String str) {

            }
        });
    }
}
