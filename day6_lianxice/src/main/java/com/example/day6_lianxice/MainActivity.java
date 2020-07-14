package com.example.day6_lianxice;


import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.day6_lianxice.activity.WebActivity;
import com.example.day6_lianxice.adapter.MyAdapter;
import com.example.day6_lianxice.base.BaseActivity;
import com.example.day6_lianxice.bean.MyBean;
import com.example.day6_lianxice.presenter.MyPresenter;
import com.example.day6_lianxice.view.MyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MyPresenter> implements MyView {

    @BindView(R.id.toolbar)
    Toolbar mtoolbar;
    @BindView(R.id.recycler)
    RecyclerView mrecycler;
    private List<MyBean.DataBean.DatasBean> list;
    private MyAdapter myAdapter;


    @Override
    protected void initPresenter() {
        mPresenter = new MyPresenter();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mPresenter.setString();
    }

    @Override
    protected void initView() {
        TextView textView = (TextView) mtoolbar.getChildAt(0);
        textView.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        mrecycler.setLayoutManager(new LinearLayoutManager(this));
        mrecycler.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        mrecycler.setAdapter(myAdapter);

        myAdapter.setModelserten(new MyAdapter.Modelserten() {
            @Override
            public void post(String link, String desc) {
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                intent.putExtra("link",link);
                intent.putExtra("desc",desc);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setData(MyBean myBean) {
        List<MyBean.DataBean.DatasBean> datas = myBean.getData().getDatas();
        list.addAll(datas);
        Log.d("111", "setData: "+list.size());
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
