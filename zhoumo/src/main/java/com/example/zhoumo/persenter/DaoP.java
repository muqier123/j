package com.example.zhoumo.persenter;

import com.example.zhoumo.base.BasePresenter;
import com.example.zhoumo.bean.DaoBean;
import com.example.zhoumo.mainview.DaoV;
import com.example.zhoumo.model.DaoM;
import com.example.zhoumo.net.ResultCallBack;

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
