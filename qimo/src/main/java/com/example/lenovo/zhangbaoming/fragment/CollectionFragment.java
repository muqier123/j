package com.example.lenovo.zhangbaoming.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.zhangbaoming.R;
import com.example.lenovo.zhangbaoming.adapter.DbAdapter;
import com.example.lenovo.zhangbaoming.adapter.VpRecyAdapter;
import com.example.lenovo.zhangbaoming.bean.Student;
import com.example.lenovo.zhangbaoming.bean.VpBean;
import com.example.lenovo.zhangbaoming.server.DbUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectionFragment extends Fragment implements DbAdapter.longClick {

    private ArrayList<Student> students = new ArrayList<>();
    private RecyclerView coll;
    private DbAdapter adapter;

    public CollectionFragment() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            initData();
        }else {
            students.clear();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_coll, container, false);
        initView(inflate);
        return inflate;
    }

    private void initData() {
        List<Student> query = DbUtils.getDb().query();
        students.addAll(query);
        adapter.setStudents(students);
        adapter.notifyDataSetChanged();
    }

    private void initView(View inflate) {
        coll = (RecyclerView) inflate.findViewById(R.id.coll);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        coll.setLayoutManager(manager);
        adapter = new DbAdapter(getContext(), students);
        coll.setAdapter(adapter);
        adapter.setLongClick(this);
    }


    @Override
    public void longClick(int position, Student bean) {
        students.remove(bean);
        DbUtils.getDb().delete(bean);
        adapter.notifyDataSetChanged();
    }
}
