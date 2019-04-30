package com.example.chouqu.base;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;




/**
 * Created by asus on 2019/3/5.
 */

public class BaseApp extends Application {
    private static BaseApp sBaseApp;
    //默认不是夜间模式
 /*   private static DaoSession daoSession;
    public static int mMode = AppCompatDelegate.MODE_NIGHT_NO;
    private static  RecentBeanDao recentBeanDao;*/


    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApp = this;
       /* setDayNightMode();*/
    }

   /* private void setDayNightMode() {
        //根据SP里面的模式设置对应的日夜间模式
       //  SpUtil.setParam(Constants.MODE,AppCompatDelegate.MODE_NIGHT_YES);
        mMode = (int) SpUtil.getParam(Constants.MODE, AppCompatDelegate.MODE_NIGHT_NO);
        UIModeUtil.setAppMode(mMode);


    }
*/
    /*private void initDb() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "gn.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        recentBeanDao = daoSession.getRecentBeanDao();

    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
*/
    public static BaseApp getInstance(){
        return sBaseApp;
    }



}
