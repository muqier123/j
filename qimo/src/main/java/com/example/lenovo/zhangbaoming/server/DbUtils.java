package com.example.lenovo.zhangbaoming.server;

import com.example.lenovo.zhangbaoming.MyApp;
import com.example.lenovo.zhangbaoming.bean.Student;
import com.example.lenovo.zhangbaoming.dao.DaoMaster;
import com.example.lenovo.zhangbaoming.dao.DaoSession;
import com.example.lenovo.zhangbaoming.dao.StudentDao;

import java.util.List;

public class DbUtils {

    private final StudentDao studentDao;

    public DbUtils() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(MyApp.getApp(), "user.db");
        DaoMaster master = new DaoMaster(helper.getWritableDatabase());
        DaoSession daoSession = master.newSession();
        studentDao = daoSession.getStudentDao();
    }
    public static DbUtils db;

    public static DbUtils getDb() {
        if (db == null){
            synchronized (DbUtils.class){
                if (db == null){
                    db = new DbUtils();
                }

            }
        }
        return db;
    }
    public boolean has(Student student){
        List<Student> list = studentDao.queryBuilder().where(StudentDao.Properties.Name.eq(student.getName())).list();
        if (list!=null && list.size()>0){
            return true;
        }
        return false;
    }

    public long insert(Student student){
        if (!has(student)){
            studentDao.insert(student);
        }
        return -1;
    }
    public boolean delete(Student student){
        if (has(student)){
            studentDao.delete(student);
            return true;
        }
        return false;
    }

    public List<Student> query(){
        return studentDao.queryBuilder().list();
    }



}
