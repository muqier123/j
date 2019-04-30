package com.example.app2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.app2.adapter.MainTabAdapter;
import com.example.app2.base.BaseActivity;
import com.example.app2.base.BaseFragment;
import com.example.app2.fragment.AFragment;
import com.example.app2.fragment.BFragment;
import com.example.app2.fragment.CFragment;
import com.example.app2.presenter.MainP;
import com.example.app2.view.Main2Activity;
import com.example.app2.view.MainView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainView, MainP> implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    @BindView(R.id.tl)
    Toolbar tl;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.nv)
    NavigationView nv;
    @BindView(R.id.dr)
    DrawerLayout dr;

    private ArrayList<BaseFragment> list;
    private ArrayList<String> title;
    private MainTabAdapter adapter;
    private NotificationManager manager;
    private PopupWindow popupWindow;
    private Button bt4;
    private Button bt3;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected MainP initPresenter() {
        return new MainP();
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        title = new ArrayList<>();
        list.add(new AFragment());
        list.add(new BFragment());
        list.add(new CFragment());
        title.add("A");
        title.add("B");
        title.add("C");
        adapter = new MainTabAdapter(getSupportFragmentManager(),list,title);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);



    }

    @Override
    protected void initView() {
        IntentFilter intentFilter = new IntentFilter("aa");
        registerReceiver(broadcastReceiver,intentFilter);
        initToolBar();
        initDraw();
    }

    private void initDraw() {
        nv.setNavigationItemSelectedListener(this);

    }

    private void initToolBar() {
        tl.setTitle("欢迎");
        setSupportActionBar(tl);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dr, tl, R.string.app_name, R.string.app_name);
        dr.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Toast.makeText(this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
        switch (menuItem.getItemId()) {
            case R.id.mp1:
                popu();
                break;
            case R.id.mp2:
                initGuang();
                break;
            case R.id.mp3:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + "155176883939");
                intent.setData(data);
                startActivity(intent);
                break;
        }
        return false;
    }

    private void initGuang() {

        Intent intent = new Intent("aa");
        intent.putExtra("msg","哈哈");
        sendBroadcast(intent);
    }

    private void popu() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_popu, null);
        popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(dr, Gravity.CENTER, 0, 0);
        bt3 = inflate.findViewById(R.id.bt3);
        bt4 = inflate.findViewById(R.id.bt4);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mo,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mo1:
                tong();
                break;
            case R.id.mo2:
                manager.cancel(100);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void tong() {
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String channelId = "1";
        String channelName = "default";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.setShowBadge(true);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("fadasda");
        builder.setContentText("Dasdsadas");
        builder.setAutoCancel(true);
        builder.setDefaults(Notification.DEFAULT_ALL);
        Notification notification = builder.build();
        manager.notify(100, notification);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt3:
                popupWindow.dismiss();
                break;
            case R.id.bt4:
                popupWindow.dismiss();
                break;
        }
    }
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Intent intent1 = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent1);
        }
    };
}
