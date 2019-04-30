package com.example.zhoumo.model;

import com.example.zhoumo.DbUtils;
import com.example.zhoumo.Util;
import com.example.zhoumo.base.BaseMode;
import com.example.zhoumo.bean.StudentBean;
import com.example.zhoumo.net.ResultCallBack;

import java.util.List;

public class StuM extends BaseMode {
    public void getData(ResultCallBack<StudentBean> resultCallBack) {
        List<StudentBean> stuBeans = DbUtils.getDbUtils().queryAll();
        resultCallBack.onSuccess((StudentBean) stuBeans);
    }
}
