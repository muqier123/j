package com.example.app2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.app2.R;
import com.example.app2.bean.ABean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ARecyAdapter extends RecyclerView.Adapter<ARecyAdapter.ViewHolder> {
    private ArrayList<ABean.ResultsBean> list;
    private Context context;

    public ARecyAdapter(ArrayList<ABean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<ABean.ResultsBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ARecyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item_a, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ARecyAdapter.ViewHolder viewHolder, int i) {

        ABean.ResultsBean bean = list.get(i);
        viewHolder.name.setText(bean.getDesc());
        viewHolder.title.setText(bean.getSource());
        Glide.with(context).load(bean.getUrl()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.tit)
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
