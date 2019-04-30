package com.example.zhoumo.mainview;

import com.example.zhoumo.base.BaseMvpView;
import com.example.zhoumo.bean.StudentBean;

public interface StuV extends BaseMvpView {
    void  setData(StudentBean stuBean);
}
