package com.example.day2_chouqu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day2_chouqu.R;
import com.example.day2_chouqu.bean.MyBean;


import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    Context context;
    List<MyBean.ResultsBean> list;
    private ImageView mImgIm;
    private TextView mTitleTv;

    public MyAdapter(Context context, List<MyBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_itme, viewGroup, false);
        return new ViewHolder1(inflate);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyBean.ResultsBean resultsBean = list.get(i);
        ViewHolder1 viewHolder1= (ViewHolder1) viewHolder;
        viewHolder1.title.setText(resultsBean.getDesc());
        Glide.with(context).load(resultsBean.getUrl()).into(viewHolder1.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.im_img);
            title = itemView.findViewById(R.id.tv_title);
        }
    }
}
