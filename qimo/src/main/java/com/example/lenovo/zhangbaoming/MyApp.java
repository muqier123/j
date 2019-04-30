package com.example.lenovo.zhangbaoming;

import android.app.Application;

public class MyApp extends Application {
    private static MyApp app;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static MyApp getApp() {
        return app;
    }
}
