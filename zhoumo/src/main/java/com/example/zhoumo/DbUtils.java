package com.example.zhoumo;

import com.example.zhoumo.base.BaseApp;
import com.example.zhoumo.bean.StudentBean;
import com.example.zhoumo.dao.DaoMaster;
import com.example.zhoumo.dao.DaoSession;
import com.example.zhoumo.dao.StudentBeanDao;

import java.util.List;
//import com.example.zhoumo.dao.StuBeanDao;

public class DbUtils {
    private static DbUtils dbUtils;
    private final StudentBeanDao stuBeanDao;

    public DbUtils() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(BaseApp.getInstance(), "ss.db");
        DaoMaster daoMaster = new DaoMaster(helper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        stuBeanDao = daoSession.getStudentBeanDao();
    }

    public static DbUtils getDbUtils() {
        if (dbUtils == null) {
            synchronized (DbUtils.class) {
                if (dbUtils == null) {
                    dbUtils = new DbUtils();
                }
            }
        }
        return dbUtils;
    }

    public void add(StudentBean stuBean) {
        stuBeanDao.insertOrReplaceInTx(stuBean);
    }

    public List<StudentBean> queryAll() {
        return stuBeanDao.queryBuilder().list();
    }
}
