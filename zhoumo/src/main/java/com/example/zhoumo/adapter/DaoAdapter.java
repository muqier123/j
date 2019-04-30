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
import com.example.zhoumo.bean.DaoBean;

import java.util.ArrayList;

public class DaoAdapter extends RecyclerView.Adapter<DaoAdapter.ViewHloder> {
    private ArrayList<DaoBean.DataBeanX.DataBean>list;
    private Context context;

    public DaoAdapter(ArrayList<DaoBean.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<DaoBean.DataBeanX.DataBean> list) {
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
    public void onBindViewHolder(@NonNull ViewHloder viewHloder, final int i) {
        final DaoBean.DataBeanX.DataBean dataBean = list.get(i);
        viewHloder.tv.setText(list.get(i).getAuthor());
        viewHloder.tv2.setText(list.get(i).getDesc());
        Glide.with(context).load(list.get(i).getCover()).into(viewHloder.im);

        viewHloder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClick!=null){
                    onClick.onClik(dataBean,i);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHloder extends RecyclerView.ViewHolder {
        private ImageView im;
        private TextView tv;
        private TextView tv2;

        public ViewHloder(@NonNull View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.im_item2);
            tv=itemView.findViewById(R.id.tv1_item2);
            tv2=itemView.findViewById(R.id.tv2_item2);
        }
    }
   public interface OnClick{
        void  onClik ( DaoBean.DataBeanX.DataBean dataBean,int i);


   }
   private OnClick onClick;

    public void setOnClick(OnClick onClick)
    {
        this.onClick = onClick;
    }
}
