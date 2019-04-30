package com.example.chouqu.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chouqu.R;
import com.example.chouqu.adpter.FuLiAadpter;
import com.example.chouqu.base.BaseFragment;
import com.example.chouqu.base.BaseMode;
import com.example.chouqu.base.BaseMvpView;
import com.example.chouqu.base.BasePresenter;
import com.example.chouqu.bean.Fuli;
import com.example.chouqu.mainview.FuLiV;
import com.example.chouqu.persenter.FuliP;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends BaseFragment<FuLiV,FuliP>implements FuLiV {
    @BindView(R.id.rl)
    RecyclerView rl;
    private ArrayList<Fuli.ResultsBean>list;
    private FuLiAadpter fuLiAadpter;


    @Override
    protected FuliP initPresent() {
        return new FuliP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank_fragment2;
    }

    @Override
    protected void initView() {
        present.getData();
        list=new ArrayList<>();
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        rl.setLayoutManager(manager);
        fuLiAadpter = new FuLiAadpter(list, getActivity());
        rl.setAdapter(fuLiAadpter);

    }
    @Override
    public void setData(Fuli fuli){
        List<Fuli.ResultsBean> results = fuli.getResults();
        Log.i("fuli", "fuli: "+results.toString());
        list.addAll(results);
        fuLiAadpter.notifyDataSetChanged();

    }
}
