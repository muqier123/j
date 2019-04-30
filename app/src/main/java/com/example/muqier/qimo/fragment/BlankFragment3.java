package com.example.muqier.qimo.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.muqier.qimo.R;
import com.example.muqier.qimo.adapter.VpAadpter;
import com.example.muqier.qimo.bean.TabBean;
import com.example.muqier.qimo.bean.VpBean;
import com.example.muqier.qimo.mainview.MainView;
import com.example.muqier.qimo.model.MainModelmpl;
import com.example.muqier.qimo.persenter.MainPersenter;
import com.example.muqier.qimo.persenter.MainPersentermpl;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class BlankFragment3 extends Fragment implements MainView {


    private View view;
    private RecyclerView mRll;
    private ArrayList<VpBean.DataBean.DatasBean>list;
    private VpAadpter vpAadpter;


    @SuppressLint("ValidFragment")
    public BlankFragment3(int id) {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_blank_fragment3, container, false);
        initView(inflate);
        initData();

        return inflate;
    }

    private void initData() {
        MainPersenter mainPersenter=new MainPersentermpl(new MainModelmpl(),this);
        mainPersenter.getData1();
    }

    private void initView(View inflate) {
        mRll = (RecyclerView) inflate.findViewById(R.id.rll);
        list=new ArrayList<>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRll.setLayoutManager(gridLayoutManager);

        vpAadpter = new VpAadpter(list, getActivity());
        mRll.setAdapter(vpAadpter);




    }

    @Override
    public void onSuccess(TabBean tabBean) {

    }

    @Override
    public void onFeil(String str) {

    }

    @Override
    public void onSuccesss(VpBean vpBean) {
        List<VpBean.DataBean.DatasBean> datas = vpBean.getData().getDatas();
        list.addAll(datas);
        vpAadpter.setList(list);
        vpAadpter.notifyDataSetChanged();
    }

    @Override
    public void onFeill(String str) {

    }
}
