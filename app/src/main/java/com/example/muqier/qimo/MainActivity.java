package com.example.muqier.qimo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * 看车 买车 选车 聊车
     */
    int i=3;

    private TextView mTv;

    @SuppressLint("HandlerLeak")
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1){
                if (i>0){
                    i--;
                    mTv.setText(""+i);
                    handler.sendEmptyMessageDelayed(1,1000);
                }else {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);


                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        handler.sendEmptyMessageDelayed(1,1000);
        jianbian();
    }
    public  void jianbian(){
        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 2, 1, 2);
        scaleAnimation.setDuration(3000);
        scaleAnimation.setFillAfter(true);
        mTv.setAnimation(scaleAnimation);

    }
}
