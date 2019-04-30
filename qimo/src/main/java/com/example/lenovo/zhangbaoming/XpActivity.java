package com.example.lenovo.zhangbaoming;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.Serializable;

public class XpActivity extends AppCompatActivity {

    private ImageView xq_iv1;
    private TextView xq_tv1;
    private TextView xq_tv2;
    private TextView xq_tv3;
    private TextView xq_tv4;
    private ImageView xq_iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xp);
        Intent intent = getIntent();
        String title = (String) intent.getSerializableExtra("title");
        String name = (String) intent.getSerializableExtra("name");
        String supe = (String) intent.getSerializableExtra("supe");
        String ch = (String) intent.getSerializableExtra("ch");
        String pic = (String) intent.getSerializableExtra("pic");
        String pic2 = (String) intent.getSerializableExtra("pic2");


        initView();
        Glide.with(this).load(pic).apply(new RequestOptions().circleCrop()).into(xq_iv1);
        Glide.with(this).load(pic2).into(xq_iv2);
        xq_tv1.setText(title);
        xq_tv2.setText(supe);
        xq_tv3.setText(ch);
        xq_tv4.setText(name);

    }

    private void initView() {
        xq_iv1 = (ImageView) findViewById(R.id.xq_iv1);
        xq_tv1 = (TextView) findViewById(R.id.xq_tv1);
        xq_tv2 = (TextView) findViewById(R.id.xq_tv2);
        xq_tv3 = (TextView) findViewById(R.id.xq_tv3);
        xq_tv4 = (TextView) findViewById(R.id.xq_tv4);
        xq_iv2 = (ImageView) findViewById(R.id.xq_iv2);
    }
}
