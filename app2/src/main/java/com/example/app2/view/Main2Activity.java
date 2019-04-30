package com.example.app2.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.app2.MainActivity;
import com.example.app2.R;
import com.example.app2.base.BaseActivity;
import com.example.app2.presenter.MainP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main2Activity extends BaseActivity<MainView, MainP> {

    @BindView(R.id.pb)
    ProgressBar pb;
    @BindView(R.id.bt6)
    Button bt6;
    @BindView(R.id.mi)
    ImageView mi;
    private File sd;

    @Override
    protected int initLayout() {
        return R.layout.activity_main2;
    }

    @Override
    protected MainP initPresenter() {
        return new MainP();
    }

    @OnClick(R.id.bt6)
    public void onViewClicked() {
        init();
    }

    private void init() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED) {
            upLog();
        } else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    100);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100&&grantResults.length>0&&grantResults[0] ==
                PackageManager.PERMISSION_GRANTED) {
            upLog();
        }
    }

    private void upLog() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            sd = Environment.getExternalStorageDirectory();
        }
        okDownload(sd+"/"+"a.apk");
    }


    private void okDownload(final String path) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        Request request = new Request.Builder()
                .url("http://cdn.banmi.com/banmiapp/apk/banmi_330.apk")
                .get()
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Main2Activity.this, "下载失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream inputStream = response.body().byteStream();
                long max = response.body().contentLength();
                savaFile(inputStream, path, max);
            }
        });
    }

    private void savaFile(InputStream inputStream, final String path, long max) {

        try {
            File file = new File(path);
            FileOutputStream outputStream = new FileOutputStream(file);

            int length = -1;
            byte[] bys = new byte[1024 * 10];

            long count = 0;

            while ((length = inputStream.read(bys)) != -1) {
                outputStream.write(bys, 0, length);

                count += length;

                Log.d("tag", "savaFile: count" + count + ", max:" + max);
                pb.setMax((int) max);
                pb.setProgress((int) count);
            }

            inputStream.close();
            outputStream.close();

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(Main2Activity.this, "下载成功", Toast.LENGTH_SHORT).show();
                    //InstallUtil.installApk(Main2Activity.this,path);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
