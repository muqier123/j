package com.example.lenovo.zhangbaoming;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

//张宝明           A场
public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //缩放
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(tv, "scaleY", 0, 2);
        scaleY.setDuration(5000);
        scaleY.start();

        new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv.setText("看车    选车  买车    聊车");
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        }.start();


    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
    }
}
