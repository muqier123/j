package com.example.muqier.qimo.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.muqier.qimo.R;
import com.example.muqier.qimo.adapter.TabAadpter;
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
public class BlankFragment extends Fragment implements MainView {


    private View view;
    private RecyclerView mRl;
    private ArrayList<Fragment> fragments;
    private ViewPager mVpMain;
    private TabLayout mTabMain;
    private TabAadpter tabAadpter;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);
        initView(inflate);
        initData();
        return inflate;

    }

    private void initData() {
        MainPersenter mainPersenter = new MainPersentermpl(new MainModelmpl(), this);
        mainPersenter.getData();
    }

    private void initView(View inflate) {
        mVpMain = (ViewPager) inflate.findViewById(R.id.vp_main);
        mTabMain = (TabLayout) inflate.findViewById(R.id.tab_main);
        fragments = new ArrayList<>();


        tabAadpter = new TabAadpter(getChildFragmentManager(), fragments);
        mVpMain.setAdapter(tabAadpter);



    }

    @Override
    public void onSuccess(TabBean tabBean) {
        final List<TabBean.DataBean> data = tabBean.getData();
        for (int i = 0; i <data.size() ; i++) {
            fragments.add(new BlankFragment3(data.get(i).getId()));
            mTabMain.addTab(mTabMain.newTab().setText(data.get(i).getName()));
        }
        mTabMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVpMain.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mVpMain.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabMain));

        tabAadpter.notifyDataSetChanged();



    }

    @Override
    public void onFeil(String str) {

    }

    @Override
    public void onSuccesss(VpBean vpBean) {

    }

    @Override
    public void onFeill(String str) {

    }
}
