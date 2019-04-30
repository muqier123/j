package com.example.zhoumo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

//基类
public abstract class BaseActivity<V extends BaseMvpView,P extends BasePresenter>
        extends AppCompatActivity implements BaseMvpView{

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //ButterKnife绑定  在任何一个子类都可以用他
        ButterKnife.bind(this);
        //初始化P层
        presenter = initPresenter();
        if (presenter != null){
            //直接强转不对，因为BaseActivity不作为页面去展示,展示的都是子类,子类都得实现BaseMVPView
            presenter.bind((V) this);
        }
        initView();
        initData();

        initListenter();
    }

    protected abstract P initPresenter();

    protected void initData() {

    }

    protected void initListenter() {

    }

    protected void initView() {

    }

    protected abstract int getLayoutId();
}
