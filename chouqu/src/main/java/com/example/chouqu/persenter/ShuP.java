package com.example.chouqu.persenter;

import com.example.chouqu.base.BasePresenter;
import com.example.chouqu.bean.ShujuBean;
import com.example.chouqu.mainview.ShuV;
import com.example.chouqu.model.ShuM;
import com.example.chouqu.net.ResultCallBack;

public class ShuP extends BasePresenter<ShuV>{
   private ShuM shuM;


    @Override
    protected void initModel() {
        shuM=new ShuM();
        mModels.add(shuM);
    }
    public void getData(){
      shuM.getData(new ResultCallBack<ShujuBean>() {
          @Override
          public void onSuccess(ShujuBean bean) {
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
