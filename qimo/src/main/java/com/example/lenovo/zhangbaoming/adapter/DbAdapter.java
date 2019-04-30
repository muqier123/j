package com.example.lenovo.zhangbaoming.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lenovo.zhangbaoming.R;
import com.example.lenovo.zhangbaoming.bean.Student;
import com.example.lenovo.zhangbaoming.bean.VpBean;

import java.util.ArrayList;

public class DbAdapter extends RecyclerView.Adapter<DbAdapter.ViewHolder> {

    Context context;
    ArrayList<Student> students;


    public DbAdapter(Context context, ArrayList<Student> students) {
        this.context = context;
        this.students = students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item2, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final Student student = students.get(i);
        viewHolder.tv.setText(students.get(i).getName());
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (longClick!= null){
                    longClick.longClick(i,student);
                }
                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.item_tvv);

        }
    }

    longClick longClick;
    public interface longClick{
        void longClick(int position,Student bean);
    }

    public void setLongClick(DbAdapter.longClick longClick) {
        this.longClick = longClick;
    }
}
