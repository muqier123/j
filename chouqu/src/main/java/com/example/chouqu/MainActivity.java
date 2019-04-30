package com.example.chouqu;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.chouqu.adpter.FragAadpter;
import com.example.chouqu.fragment.BlankFragment;
import com.example.chouqu.fragment.BlankFragment2;
import com.example.chouqu.fragment.BlankFragment3;
import com.example.chouqu.fragment.BlankFragment4;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTab;
    private ArrayList<Fragment>fragments;
    private FragAadpter fragAadpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);

        fragments=new ArrayList<>();

        mTab.addTab(mTab.newTab().setText("玩Android"));
        mTab.addTab(mTab.newTab().setText("福利"));
        mTab.addTab(mTab.newTab().setText("盗墓笔记"));
        mTab.addTab(mTab.newTab().setText("数据"));

        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment2());
        fragments.add(new BlankFragment3());
        fragments.add(new BlankFragment4());

        fragAadpter = new FragAadpter(getSupportFragmentManager(), fragments);
        mVp.setAdapter(fragAadpter);

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
