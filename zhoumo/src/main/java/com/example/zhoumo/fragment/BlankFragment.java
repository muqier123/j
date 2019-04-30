package com.example.zhoumo.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.zhoumo.DbUtils;
import com.example.zhoumo.R;
import com.example.zhoumo.adapter.DaoAdapter;
import com.example.zhoumo.base.BaseFragment;
import com.example.zhoumo.bean.DaoBean;
import com.example.zhoumo.bean.StudentBean;
import com.example.zhoumo.mainview.DaoV;
import com.example.zhoumo.persenter.DaoP;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends BaseFragment<DaoV,DaoP>implements DaoV {
    @BindView(R.id.rl)
    RecyclerView rl;
    private ArrayList<DaoBean.DataBeanX.DataBean>list;
    private DaoAdapter daoAdapter;

    @Override
    protected DaoP initPresent() {
        return new DaoP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank;

    }

    @Override
    protected void initView() {
        present.getData();
        list=new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rl.setLayoutManager(manager);

        daoAdapter = new DaoAdapter(list, getActivity());
        rl.setAdapter(daoAdapter);

        daoAdapter.setOnClick(new DaoAdapter.OnClick() {
            @Override
            public void onClik(DaoBean.DataBeanX.DataBean bean, int i) {
                Toast.makeText(getActivity(), "66", Toast.LENGTH_SHORT).show();
                DaoBean.DataBeanX.DataBean dataBean = list.get(i);
                StudentBean stuBean = new StudentBean();
                stuBean.setId(null);
                stuBean.setAuthor(dataBean.getAuthor());
                stuBean.setCover(dataBean.getCover());
                stuBean.setDesc(dataBean.getDesc());
                Log.d("oooo", "onClik: "+stuBean.toString());
                DbUtils dbUtils = DbUtils.getDbUtils();
                dbUtils.add(stuBean);
            }
        });
    }
    @Override
    public  void  setData(DaoBean data){
        List<DaoBean.DataBeanX.DataBean> data1 = data.getData().getData();
        list.addAll(data1);
        daoAdapter.setList(list);
        daoAdapter.notifyDataSetChanged();


    }
}
