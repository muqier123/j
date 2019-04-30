package com.example.muqier.qimo.callback;

import com.example.muqier.qimo.bean.TabBean;
import com.example.muqier.qimo.bean.VpBean;

public interface CallBack {
    void onSuccess(TabBean tabBean);
    void onFeil(String str);

    void onSuccesss(VpBean vpBean);
    void onFeill(String str);


}
