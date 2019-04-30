package com.example.app2.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<V extends BaseView,P extends BasePresenter>extends Fragment
implements BaseView{

    protected P pb;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(initLayout(), null);
        unbinder = ButterKnife.bind(this, inflate);
        pb = initPresenter();
        if (pb!=null) {
            pb.bind((V)this);
        }
        initData();
        initView();
        initList();
        return inflate;
    }
    protected void initData(){}
    protected void initView(){}
    protected void initList(){}
    protected abstract P initPresenter();
    protected abstract int initLayout();
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        pb.onDestory();
        pb=null;
    }
}
