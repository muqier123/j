package com.example.lenovo.zhangbaoming.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lenovo.zhangbaoming.R;
import com.example.lenovo.zhangbaoming.adapter.Coll_tabAdapter;
import com.example.lenovo.zhangbaoming.bean.TabBean;
import com.example.lenovo.zhangbaoming.model.ModelPics;
import com.example.lenovo.zhangbaoming.penter.PenterPics;
import com.example.lenovo.zhangbaoming.view.MainView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhuyeFragment extends Fragment implements MainView {


    private ArrayList<TabBean.DataBean> list;
    private TabLayout tabb;
    private ViewPager vpp;
    private View view;
    private Toolbar mToolbar;
    private ArrayList<String> title;

    public ZhuyeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_zhuye, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        PenterPics pics = new PenterPics(new ModelPics(), this);
        pics.getData();
    }

    private void initView(View inflate) {

        list = new ArrayList<>();
        title = new ArrayList<>();
        title.add("首页");
        title.add("收藏");

        tabb = (TabLayout) inflate.findViewById(R.id.tabb);
        vpp = (ViewPager) inflate.findViewById(R.id.vpp);

    }

    @Override
    public void onSucces(TabBean bean) {
        List<TabBean.DataBean> data = bean.getData();
        ArrayList<Fragment> frag = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            frag.add(new ChildFragment(data.get(i).getId()));
            tabb.addTab(tabb.newTab().setText(data.get(i).getName()));
        }
        Coll_tabAdapter coll = new Coll_tabAdapter(getChildFragmentManager(), frag);
        vpp.setAdapter(coll);

        //tab与vp的互相绑定
        tabb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpp.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vpp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabb));

    }

    @Override
    public void onFails(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
    }
}
