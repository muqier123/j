package com.example.chouqu.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chouqu.R;
import com.example.chouqu.adpter.DaoAadpter;
import com.example.chouqu.base.BaseFragment;
import com.example.chouqu.bean.DaoBean;
import com.example.chouqu.mainview.DaoV;
import com.example.chouqu.persenter.DaoP;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment3 extends BaseFragment<DaoV,DaoP>implements DaoV {
    @BindView(R.id.rl)
    RecyclerView rl;
    private ArrayList<DaoBean.DataBeanX.DataBean>list;
    private DaoAadpter daoAadpter;


    @Override
    protected DaoP initPresent() {
        return new DaoP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank_fragment3;
    }

    @Override
    protected void initView() {
        present.getData();
        list=new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rl.setLayoutManager(manager);

        daoAadpter = new DaoAadpter(list, getActivity());
        rl.setAdapter(daoAadpter);


    }
    @Override
    public void setData(DaoBean data){
        List<DaoBean.DataBeanX.DataBean> data1 = data.getData().getData();
        list.addAll(data1);
        daoAadpter.setList(list);
        daoAadpter.notifyDataSetChanged();

    }
}
