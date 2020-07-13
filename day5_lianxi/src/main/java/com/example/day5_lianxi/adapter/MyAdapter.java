package com.example.day5_lianxi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day5_lianxi.R;
import com.example.day5_lianxi.bean.MyBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Context context;
    List<MyBean.T1348647909107Bean> list = new ArrayList<>();
    public boolean onWrit = false;

    public MyAdapter(Context context) {
        this.context = context;
    }
    public void addData(List<MyBean.T1348647909107Bean> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_itme, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final MyBean.T1348647909107Bean t1348647909107Bean = list.get(i);

        if(onWrit==true){
                viewHolder.cbBox.setVisibility(View.VISIBLE);
            }else{
                viewHolder.cbBox.setVisibility(View.GONE);
            }
            //通过 数据来控制页面
            viewHolder.cbBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    //按钮是否被按压,也就是说是否为用户行为
                    t1348647909107Bean.setShow(isChecked);
                }
            });
            if (t1348647909107Bean.isShow()){
                viewHolder.cbBox.setChecked(true);
            }else {
                viewHolder.cbBox.setChecked(false);
        }
        viewHolder.tvTitle.setText(t1348647909107Bean.getTitle());
        Glide.with(context).load(t1348647909107Bean.getImgsrc()).into(viewHolder.imgImgview);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_imgview)
        ImageView imgImgview;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.cb_box)
        CheckBox cbBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
