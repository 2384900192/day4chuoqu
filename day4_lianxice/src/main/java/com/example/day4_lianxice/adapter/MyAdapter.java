package com.example.day4_lianxice.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day4_lianxice.R;
import com.example.day4_lianxice.bean.MyBean;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    Context context;
    List<MyBean> list;
    private ImageView mImgerIm;
    private TextView mNameTv;
    private TextView mDataTv;

    public MyAdapter(Context context, List<MyBean> list) {
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
        final MyBean myBean = list.get(i);
        ViewHolder1 viewHolder1= (ViewHolder1) viewHolder;
        viewHolder1.mNameTv.setText(myBean.getName());
        viewHolder1.mDataTv.setText(myBean.getDate());
        Glide.with(context).load(myBean.getImgervirew()).into(viewHolder1.mImgerIm);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mododersd!=null){
                    mododersd.post(myBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        ImageView mImgerIm;
        TextView mNameTv, mDataTv;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            mImgerIm = itemView.findViewById(R.id.im_imger);
            mNameTv =  itemView.findViewById(R.id.tv_name);
            mDataTv =  itemView.findViewById(R.id.tv_data);
        }
    }

    Mododersd mododersd;

    public void setMododersd(Mododersd mododersd) {
        this.mododersd = mododersd;
    }
    public  interface Mododersd{
        void post(MyBean myBean);
    }
}
