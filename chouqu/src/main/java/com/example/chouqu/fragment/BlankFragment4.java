package com.example.chouqu.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chouqu.R;
import com.example.chouqu.adpter.ShuAdapter;
import com.example.chouqu.base.BaseFragment;
import com.example.chouqu.bean.ShujuBean;
import com.example.chouqu.mainview.ShuV;
import com.example.chouqu.persenter.ShuP;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment4 extends BaseFragment<ShuV,ShuP>implements ShuV {
        @BindView(R.id.rl)
    RecyclerView rl;
        private ArrayList<ShujuBean.ResultBean>list;
    private ShuAdapter shuAdapter;


    @Override
    protected ShuP initPresent() {
        return new ShuP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank_fragment4;

    }

    @Override
    protected void initView() {
        present.getData();
        list=new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rl.setLayoutManager(manager);

        shuAdapter = new ShuAdapter(list, getActivity());
        rl.setAdapter(shuAdapter);



    }
    @Override
    public void setData(ShujuBean shujuBean){
        List<ShujuBean.ResultBean> result = shujuBean.getResult();
        list.addAll(result);
        shuAdapter.setList(list);
        shuAdapter.notifyDataSetChanged();

    }
}
