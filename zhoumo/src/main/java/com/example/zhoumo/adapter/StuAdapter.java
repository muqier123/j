package com.example.zhoumo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.example.zhoumo.R;
import com.example.zhoumo.bean.StudentBean;

import java.util.ArrayList;

public class StuAdapter extends RecyclerView.Adapter<StuAdapter.ViewHolder> {
    private ArrayList<StudentBean>list;
    private Context context;

    public StuAdapter(ArrayList<StudentBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<StudentBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item2, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
      final   StudentBean stuBean = list.get(i);
        viewHolder.tv2.setText(list.get(i).getAuthor());
        viewHolder.tv.setText(list.get(i).getDesc());
        Glide.with(context).load(list.get(i).getCover()).into(viewHolder.im);

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (onLongClick!=null){
                    onLongClick.onClickLong(stuBean,i);
                }
                return false;
            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClick!=null){
                    onClick.onClivk(stuBean,i);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private TextView tv2;
        private ImageView im;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv1_item2);
            tv2=itemView.findViewById(R.id.tv2_item2);
            im=itemView.findViewById(R.id.im_item2);
        }
    }
    public  interface  onLongClick{
        void onClickLong( StudentBean stuBean, int i);

    }
    private onLongClick onLongClick;

    public void setOnLongClick(StuAdapter.onLongClick onLongClick) {
        this.onLongClick = onLongClick;
    }

    public  interface  onClick{
        void onClivk( StudentBean stuBean, int i);

    }
    private onClick onClick;

    public void setOnClick(StuAdapter.onClick onClick) {
        this.onClick = onClick;
    }
}
