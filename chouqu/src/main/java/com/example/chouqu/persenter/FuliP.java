package com.example.chouqu.persenter;

import com.example.chouqu.base.BasePresenter;
import com.example.chouqu.bean.Fuli;
import com.example.chouqu.mainview.FuLiV;
import com.example.chouqu.model.FuLiM;
import com.example.chouqu.net.ResultCallBack;

import retrofit2.Retrofit;

public class FuliP extends BasePresenter<FuLiV> {
  private FuLiM fuLiM;


    @Override
    protected void initModel() {
        fuLiM=new FuLiM();
        mModels.add(fuLiM);
    }

   public void getData(){
        fuLiM.getData(new ResultCallBack<Fuli>() {
            @Override
            public void onSuccess(Fuli bean) {
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
