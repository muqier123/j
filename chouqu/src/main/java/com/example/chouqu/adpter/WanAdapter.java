package com.example.chouqu.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.chouqu.R;
import com.example.chouqu.bean.VpBean;

import java.util.ArrayList;

public class WanAdapter extends RecyclerView.Adapter<WanAdapter.ViewHloder> {
    private ArrayList<VpBean.DataBean.DatasBean>list;
    private Context context;

    public WanAdapter(ArrayList<VpBean.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<VpBean.DataBean.DatasBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHloder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item2, null);
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
    public int getItemCount() {
        return list.size();
    }

    public class ViewHloder extends RecyclerView.ViewHolder {
        private ImageView im;
        private TextView tv1;
        private TextView tv2;

        public ViewHloder(@NonNull View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.im_item2);
            tv1=itemView.findViewById(R.id.tv1_item2);
            tv2=itemView.findViewById(R.id.tv2_item2);
        }
    }
}
