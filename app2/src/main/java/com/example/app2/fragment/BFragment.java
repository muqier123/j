package com.example.app2.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.app2.R;
import com.example.app2.base.BaseFragment;
import com.example.app2.presenter.BPresenter;
import com.example.app2.view.BView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends BaseFragment<BView, BPresenter> implements BView {


    @BindView(R.id.wb)
    WebView wb;

    @Override
    protected BPresenter initPresenter() {
        return new BPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_b;
    }

    @Override
    protected void initData() {
        wb.getSettings().setJavaScriptEnabled(true);
        wb.setWebViewClient(new WebViewClient());
        wb.loadUrl("https://www.baidu.com/");
    }
}
