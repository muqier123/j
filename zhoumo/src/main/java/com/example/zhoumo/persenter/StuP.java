package com.example.zhoumo.persenter;

import com.example.zhoumo.base.BasePresenter;
import com.example.zhoumo.bean.StudentBean;
import com.example.zhoumo.mainview.StuV;
import com.example.zhoumo.model.StuM;
import com.example.zhoumo.net.ResultCallBack;

public class StuP extends BasePresenter<StuV> {
    private StuM stuM;

    @Override
    protected void initModel() {
        stuM=new StuM();
        mModels.add(stuM);
    }
    public void getData(){
        stuM.getData(new ResultCallBack<StudentBean>() {
            @Override
            public void onSuccess(StudentBean bean) {
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
