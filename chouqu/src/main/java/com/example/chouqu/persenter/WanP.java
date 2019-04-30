package com.example.chouqu.persenter;

import com.example.chouqu.base.BasePresenter;
import com.example.chouqu.bean.VpBean;
import com.example.chouqu.mainview.WanV;
import com.example.chouqu.model.WanM;
import com.example.chouqu.net.ResultCallBack;

public class WanP extends BasePresenter<WanV> {


    private WanM wanM;

    @Override
    protected void initModel() {
        wanM = new WanM();
        mModels.add(wanM);

    }
        public void  getData(){
        wanM.getData(new ResultCallBack<VpBean>() {
            @Override
            public void onSuccess(VpBean bean) {
                if (bean!=null){
                    if (mview!=null){
                        mview.setData(bean);

                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }


        });
        }
}
