package com.example.day6_lianxice.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day6_lianxice.R;
import com.example.day6_lianxice.bean.MyBean;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter {
    Context context;
    List<MyBean.DataBean.DatasBean> list;

    final static int BYTE_1 = 0;
    final static int BYTE_2 = 1;

    public MyAdapter(Context context, List<MyBean.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i) {
            case BYTE_1:
                View inflate = LayoutInflater.from(context).inflate(R.layout.activity_itme, viewGroup, false);
                return new ViewHolder1(inflate);
            case BYTE_2:
                View inflate2 = LayoutInflater.from(context).inflate(R.layout.activity_itmes, viewGroup, false);
                return new ViewHolder2(inflate2);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final MyBean.DataBean.DatasBean datasBean = list.get(i);
        int itemViewType = getItemViewType(i);
        switch (itemViewType){
            case BYTE_1:
                ViewHolder1 viewHolder1= (ViewHolder1) viewHolder;
                viewHolder1.mShijianTe.setText(datasBean.getNiceDate());
                viewHolder1.mZuozheTe.setText(datasBean.getChapterName());
                viewHolder1.mWbenTe.setText(datasBean.getTitle());
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (modelserten!=null){
                            modelserten.post(datasBean.getLink(),datasBean.getDesc());
                        }
                    }
                });
                break;
            case BYTE_2:
                ViewHolder2 viewHolder2= (ViewHolder2) viewHolder;
                viewHolder2.mZuozhe1Te.setText(datasBean.getChapterName());
                viewHolder2.mShijian1Te.setText(datasBean.getNiceDate());
                viewHolder2.mWben1Te.setText(datasBean.getTitle());
                Glide.with(context).load(datasBean.getEnvelopePic()).into(viewHolder2.mImgerImg);
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (modelserten!=null){
                            modelserten.post(datasBean.getLink(),datasBean.getDesc());
                        }
                    }
                });
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return BYTE_1;
        } else {
            return BYTE_2;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        TextView mZuozheTe;
        TextView mShijianTe;
        TextView mWbenTe;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            mZuozheTe = (TextView) itemView.findViewById(R.id.te_zuozhe);
            mShijianTe = (TextView) itemView.findViewById(R.id.te_shijian);
            mWbenTe = (TextView) itemView.findViewById(R.id.te_wben);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
         TextView mZuozhe1Te;
         TextView mShijian1Te;
         TextView mWben1Te;
         ImageView mImgerImg;
        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            mZuozhe1Te = (TextView) itemView.findViewById(R.id.te_zuozhe1);
            mShijian1Te = (TextView) itemView.findViewById(R.id.te_shijian1);
            mWben1Te = (TextView) itemView.findViewById(R.id.te_wben1);
            mImgerImg = (ImageView) itemView.findViewById(R.id.img_imger);
        }
    }
    Modelserten modelserten;

    public void setModelserten(Modelserten modelserten) {
        this.modelserten = modelserten;
    }

    public interface Modelserten{
        void post(String link, String desc);
    }
}
