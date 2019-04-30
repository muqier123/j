package com.example.chouqu.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chouqu.R;
import com.example.chouqu.adpter.WanAdapter;
import com.example.chouqu.base.BaseFragment;
import com.example.chouqu.bean.VpBean;
import com.example.chouqu.mainview.WanV;
import com.example.chouqu.persenter.WanP;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends BaseFragment<WanV,WanP>implements WanV {
        @BindView(R.id.rl)
        RecyclerView rl;

        private ArrayList<VpBean.DataBean.DatasBean>list;
        private WanAdapter wanAdapter;


    @Override
    protected WanP initPresent() {
        return new WanP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank;

    }

    @Override
    protected void initView() {
        present.getData();

        list=new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rl.setLayoutManager(manager);

        wanAdapter = new WanAdapter(list, getActivity());
        rl.setAdapter(wanAdapter);


    }
    @Override
    public void setData(VpBean vpBean){
        List<VpBean.DataBean.DatasBean> datas = vpBean.getData().getDatas();
        list.addAll(datas);
        Log.i(TAG, "setData: "+list.toString());
        wanAdapter.setList(list);
        wanAdapter.notifyDataSetChanged();

    }
}
