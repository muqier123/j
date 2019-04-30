package com.example.muqier.qimo.mainview;

import com.example.muqier.qimo.bean.TabBean;
import com.example.muqier.qimo.bean.VpBean;

public interface MainView {
    void onSuccess(TabBean tabBean);
    void onFeil(String str);

    void onSuccesss(VpBean vpBean);
    void onFeill(String str);
}
