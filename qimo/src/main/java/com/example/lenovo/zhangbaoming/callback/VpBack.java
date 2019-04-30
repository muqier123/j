package com.example.lenovo.zhangbaoming.callback;

import com.example.lenovo.zhangbaoming.bean.VpBean;

public interface VpBack {
    void onSucces(VpBean bean);
    void onFails(String s);
}
