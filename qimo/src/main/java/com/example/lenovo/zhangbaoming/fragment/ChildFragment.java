package com.example.lenovo.zhangbaoming.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lenovo.zhangbaoming.R;
import com.example.lenovo.zhangbaoming.XpActivity;
import com.example.lenovo.zhangbaoming.adapter.VpAdapter;
import com.example.lenovo.zhangbaoming.adapter.VpRecyAdapter;
import com.example.lenovo.zhangbaoming.bean.Student;
import com.example.lenovo.zhangbaoming.bean.VpBean;
import com.example.lenovo.zhangbaoming.model.VPModelPics;
import com.example.lenovo.zhangbaoming.penter.VpPenterPics;
import com.example.lenovo.zhangbaoming.server.DbUtils;
import com.example.lenovo.zhangbaoming.view.VpView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class ChildFragment extends Fragment implements VpView, VpRecyAdapter.OnClick {


    private RecyclerView ch_re;
    private ArrayList<VpBean.DataBean.DatasBean> list;
    private VpRecyAdapter adapter;
    private int id;

    public ChildFragment(int id) {
        // Required empty public constructor
        this.id = id;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){
            initData();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_child, container, false);
        initView(inflate);
        initData();

        return inflate;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,1,0,"增加");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    private int position ;
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                Student student = new Student();
                student.setId(null);
                student.setName(list.get(position).getTitle());
                DbUtils.getDb().insert(student);
                Toast.makeText(getContext(), "添加成功", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void initData() {
        VpPenterPics pics = new VpPenterPics(new VPModelPics(), this);
        pics.VpP(id);
    }

    private void initView(View inflate) {
        ch_re = (RecyclerView) inflate.findViewById(R.id.ch_re);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        ch_re.setLayoutManager(manager);
        list = new ArrayList<>();
        adapter = new VpRecyAdapter(list, getActivity());
        ch_re.setAdapter(adapter);
        adapter.setClick(this);
        registerForContextMenu(ch_re);

    }

    @Override
    public void onSucces(VpBean bean) {
        List<VpBean.DataBean.DatasBean> datas = bean.getData().getDatas();
        list.addAll(datas);
        adapter.setList(list);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onFails(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Click(int position, VpBean.DataBean.DatasBean datasBean) {
        Intent intent = new Intent(getActivity(), XpActivity.class);
        intent.putExtra("title", datasBean.getTitle());
        intent.putExtra("name", datasBean.getDesc());
        intent.putExtra("supe", datasBean.getSuperChapterName());
        intent.putExtra("ch", datasBean.getChapterName());
        intent.putExtra("pic", datasBean.getEnvelopePic());
        intent.putExtra("pic2", datasBean.getEnvelopePic());
        startActivity(intent);
    }


}
