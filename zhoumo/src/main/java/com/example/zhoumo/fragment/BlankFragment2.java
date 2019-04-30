package com.example.zhoumo.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zhoumo.R;
import com.example.zhoumo.adapter.StuAdapter;
import com.example.zhoumo.base.BaseFragment;
import com.example.zhoumo.bean.StudentBean;
import com.example.zhoumo.mainview.StuV;
import com.example.zhoumo.persenter.StuP;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends BaseFragment<StuV,StuP>implements StuV {
    @BindView(R.id.rl)
    RecyclerView rl;

    private ArrayList<StudentBean>list=new ArrayList<>();
    private StuAdapter stuAdapter;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){
           // initData();
        }  else {
            list.clear();

        }
    }


    @Override
    protected StuP initPresent() {
        return new StuP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank_fragment2;
    }
    @Override
   public void  setData(StudentBean stuBean){
        list.add(stuBean);
        stuAdapter.setList(list);
        stuAdapter.notifyDataSetChanged();
   }

    @Override
    protected void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rl.setLayoutManager(manager);

        stuAdapter = new StuAdapter(list, getActivity());
        rl.setAdapter(stuAdapter);
    }

    @Override
    protected void initData() {
      //  present.getData();
    }
}
