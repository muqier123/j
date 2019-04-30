package com.example.lenovo.zhangbaoming.callback;

import com.example.lenovo.zhangbaoming.bean.TabBean;

public interface CallBack {
    void onSucces(TabBean bean);
    void onFails(String s);
}
