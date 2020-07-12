package com.example.day5_lianxi;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.day5_lianxi.adapter.MyAdapter;
import com.example.day5_lianxi.base.BaseActivity;
import com.example.day5_lianxi.bean.MyBean;
import com.example.day5_lianxi.presenter.MyPresenter;
import com.example.day5_lianxi.view.MyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MyPresenter> implements MyView {

    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    @BindView(R.id.bu_cao)
    Button  mBuCao;
    @BindView(R.id.bu_shan)
    Button mBuShan;
    @BindView(R.id.bu_wan)
    Button mBuWan;
    private List<MyBean.T1348647909107Bean> list;
    private MyAdapter myAdapter;


    @Override
    protected void initView() {

        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(this);
        mRecycler.setAdapter(myAdapter);
    }

    @Override
    protected void initList() {

    }

    @Override
    protected void initData() {
        mPresenter.getString();
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {
        mPresenter = new MyPresenter();

    }

    @Override
    public void setData(MyBean myBean) {
        if (myBean!=null&&myBean.getT1348647909107()!=null){
            list.addAll(myBean.getT1348647909107());
            myAdapter.addData(list);

        }
    }
    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.bu_cao, R.id.bu_shan, R.id.bu_wan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bu_cao:
                myAdapter.onWrit=true;
                myAdapter.notifyDataSetChanged();
                break;
            case R.id.bu_shan:
                List<MyBean.T1348647909107Bean> lists=new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    MyBean.T1348647909107Bean t1348647909107Bean = list.get(i);
                    if (!t1348647909107Bean.isShow()){
                        lists.add(t1348647909107Bean);
                    }
                }
                list.clear();
                list.addAll(lists);
                myAdapter.addData(list);

                break;
            case R.id.bu_wan:
                myAdapter.onWrit=false;
                myAdapter.notifyDataSetChanged();
                break;
        }
    }


}
