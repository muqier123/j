package com.example.chouqu.persenter;

import com.example.chouqu.base.BaseMvpView;
import com.example.chouqu.base.BasePresenter;
import com.example.chouqu.bean.DaoBean;
import com.example.chouqu.mainview.DaoV;
import com.example.chouqu.model.DaoM;
import com.example.chouqu.net.ResultCallBack;

public class DaoP extends BasePresenter<DaoV> {

   private DaoM daoM;


    @Override
    protected void initModel() {
        daoM=new DaoM();
        mModels.add(daoM);

    }
    public void getData(){
        daoM.getData(new ResultCallBack<DaoBean>() {
            @Override
            public void onSuccess(DaoBean bean) {
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
