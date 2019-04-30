package com.example.app2.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app2.R;
import com.example.app2.adapter.ARecyAdapter;
import com.example.app2.base.BaseFragment;
import com.example.app2.bean.ABean;
import com.example.app2.presenter.APresenter;
import com.example.app2.view.AView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends BaseFragment<AView, APresenter> implements AView {


    @BindView(R.id.a_rlv)
    RecyclerView aRlv;
    private ArrayList<ABean.ResultsBean> list;
    private ARecyAdapter adapter;

    @Override
    protected APresenter initPresenter() {
        return new APresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_a;
    }

    @Override
    protected void initData() {
        pb.getData("20/1");
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        adapter = new ARecyAdapter(list,getActivity());
        aRlv.setAdapter(adapter);
        aRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void setData(ABean aBean) {
        if (aBean!=null&&aBean.getResults()!=null&&aBean.getResults().size()>0) {
            list.addAll(aBean.getResults());
            adapter.setList(list);
            adapter.notifyDataSetChanged();
        }
    }
}
