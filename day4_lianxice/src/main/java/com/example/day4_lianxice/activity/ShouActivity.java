package com.example.day4_lianxice.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.day4_lianxice.R;
import com.example.day4_lianxice.base.BaseActivity;
import com.example.day4_lianxice.base.BasePresenter;
import com.example.day4_lianxice.bean.MyBean;
import com.example.day4_lianxice.presenter.MyPresenter;
import com.example.day4_lianxice.view.MyView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShouActivity extends BaseActivity<MyPresenter> implements MyView {

    @BindView(R.id.tolbar)
    Toolbar tolbar;
    @BindView(R.id.recycler)
    RecyclerView recycler;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_shou);
//        ButterKnife.bind(this);
//    }

    @Override
    protected void initView() {
        setSupportActionBar(tolbar);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_shou;
    }

    @Override
    public void setData(List<MyBean> list) {

    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
