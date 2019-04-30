package com.example.lenovo.zhangbaoming.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lenovo.zhangbaoming.R;
import com.example.lenovo.zhangbaoming.bean.Student;
import com.example.lenovo.zhangbaoming.bean.VpBean;

import java.util.ArrayList;

public class VpRecyAdapter extends RecyclerView.Adapter<VpRecyAdapter.ViewHolder> {
    ArrayList<VpBean.DataBean.DatasBean> list;
    Context context;


    public VpRecyAdapter(ArrayList<VpBean.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }


    public void setList(ArrayList<VpBean.DataBean.DatasBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {



        final VpBean.DataBean.DatasBean datasBean = list.get(i);
        Glide.with(context).load(list.get(i).getEnvelopePic()).into(viewHolder.iv);
        Glide.with(context).load(list.get(i).getEnvelopePic()).apply(new RequestOptions().circleCrop()).into(viewHolder.iv2);
        viewHolder.tv.setText(list.get(i).getTitle()+"...");
        viewHolder.tv2.setText(list.get(i).getChapterName());
        viewHolder.ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Click!= null){
                    Click.Click(i,datasBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv2;
        private final ImageView iv;
        private final TextView tv2;
        private final TextView tv;
        private CheckBox ch;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ch=itemView.findViewById(R.id.ch);
            tv = itemView.findViewById(R.id.item_tv);
            tv2 = itemView.findViewById(R.id.item_tv2);
            iv = itemView.findViewById(R.id.item_iv);
            iv2 = itemView.findViewById(R.id.item_iv2);
        }
    }

    OnClick Click;
    public interface OnClick{
        void Click(int position,VpBean.DataBean.DatasBean bean);
    }

    public void setClick(OnClick click) {
        Click = click;
    }


    longClick longClick;
    public interface longClick{
        void longClick(int position,VpBean.DataBean.DatasBean bean);
    }

    public void setLongClick(VpRecyAdapter.longClick longClick) {
        this.longClick = longClick;
    }
}
