package com.example.muqier.qimo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.muqier.qimo.adapter.FragAdapter;
import com.example.muqier.qimo.fragment.BlankFragment;
import com.example.muqier.qimo.fragment.BlankFragment2;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTab;
    private ArrayList<Fragment>fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);

        fragments=new ArrayList<>();

        mTab.addTab(mTab.newTab().setText("主页"));
        mTab.addTab(mTab.newTab().setText("书藏"));

        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment2());

        FragAdapter fragAdapter = new FragAdapter(getSupportFragmentManager(), fragments);
        mVp.setAdapter(fragAdapter);

        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));

    }
}
