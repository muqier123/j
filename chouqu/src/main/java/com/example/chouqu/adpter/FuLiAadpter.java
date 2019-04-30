package com.example.chouqu.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.chouqu.R;
import com.example.chouqu.bean.Fuli;

import java.util.ArrayList;

public class FuLiAadpter extends RecyclerView.Adapter<FuLiAadpter.ViewHloder> {
    private ArrayList<Fuli.ResultsBean>list;
    private Context context;

    public FuLiAadpter(ArrayList<Fuli.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<Fuli.ResultsBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public FuLiAadpter.ViewHloder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item1, null);
        ViewHloder viewHloder = new ViewHloder(inflate);
        return viewHloder;
    }

    @Override
    public void onBindViewHolder(@NonNull FuLiAadpter.ViewHloder viewHloder, int i) {
        Glide.with(context).load(list.get(i).getUrl()).into(viewHloder.im);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHloder extends RecyclerView.ViewHolder {
            private ImageView im;

        public ViewHloder(@NonNull View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.im_item1);
        }
    }
}
