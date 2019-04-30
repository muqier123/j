package com.example.app2.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<V extends BaseView,P extends BasePresenter>
        extends AppCompatActivity implements BaseView{

    protected P ps;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        ButterKnife.bind(this);
        ps = initPresenter();
        if (ps!=null) {
            ps.bind((V)this);
        }
        initView();
        initList();
        initData();
    }

    protected void initData(){}
    protected void initView(){}
    protected void initList(){}
    protected abstract int initLayout();
    protected abstract P initPresenter();
}
