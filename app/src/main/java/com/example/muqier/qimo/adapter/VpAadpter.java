package com.example.muqier.qimo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.muqier.qimo.R;
import com.example.muqier.qimo.bean.VpBean;

import java.util.ArrayList;

public class VpAadpter extends RecyclerView.Adapter<VpAadpter.ViewHloder> {
    private ArrayList<VpBean.DataBean.DatasBean>list;
    private Context context;

    public VpAadpter(ArrayList<VpBean.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<VpBean.DataBean.DatasBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHloder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item1, null);
        ViewHloder viewHloder = new ViewHloder(inflate);
        return viewHloder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHloder viewHloder, int i) {
        viewHloder.tv1.setText(list.get(i).getAuthor());
        viewHloder.tv2.setText(list.get(i).getTitle());

        Glide.with(context).load(list.get(i).getEnvelopePic()).into(viewHloder.im);
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public class ViewHloder extends RecyclerView.ViewHolder {
        private ImageView im;
        private TextView tv1;
        private TextView tv2;

        public ViewHloder(@NonNull View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.im_item1);
            tv1=itemView.findViewById(R.id.tv1_item1);
            tv2=itemView.findViewById(R.id.tv2_item1);
        }
    }
}
