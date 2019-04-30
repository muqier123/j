package com.example.lenovo.zhangbaoming;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.lenovo.zhangbaoming.adapter.VpAdapter;
import com.example.lenovo.zhangbaoming.fragment.CollectionFragment;
import com.example.lenovo.zhangbaoming.fragment.ZhuyeFragment;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
       initData();

    }

    private void initData() {
        ArrayList<String> title = new ArrayList<>();
        title.add("主页");
        title.add("收藏");
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ZhuyeFragment());
        fragments.add(new CollectionFragment());
        VpAdapter adapter = new VpAdapter(getSupportFragmentManager(), fragments, title);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);
    }
}
