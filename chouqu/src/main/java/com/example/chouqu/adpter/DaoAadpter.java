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
import com.example.chouqu.bean.DaoBean;

import java.util.ArrayList;

public class DaoAadpter extends RecyclerView.Adapter<DaoAadpter.ViewHloder> {
    private ArrayList<DaoBean.DataBeanX.DataBean>list;
    private Context context;

    public DaoAadpter(ArrayList<DaoBean.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<DaoBean.DataBeanX.DataBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public DaoAadpter.ViewHloder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item3, null);
        ViewHloder viewHloder = new ViewHloder(inflate);

        return viewHloder;
    }

    @Override
    public void onBindViewHolder(@NonNull DaoAadpter.ViewHloder viewHloder, int i) {
            viewHloder.tv1.setText(list.get(i).getCategory());
            viewHloder.tv2.setText(list.get(i).getTags());
        Glide.with(context).load(list.get(i).getCover()).into(viewHloder.im);
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
            im=itemView.findViewById(R.id.im_item3);
            tv1=itemView.findViewById(R.id.tv1_item3);
            tv2=itemView.findViewById(R.id.tv2_item3);

        }
    }
}
