package com.example.day4chuoqu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.day4chuoqu.base.BaseActivity;
import com.example.day4chuoqu.prenter.MyPrenter;
import com.example.day4chuoqu.view.MyView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MyPrenter> implements MyView {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.bu_qie)
    Button buQie;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        tvName.setText("主页");
    }

    @Override
    protected void initPrenter() {
        mPrenter = new MyPrenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setData(String str) {
        tvName.setText(str);
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // TODO: add setContentView(...) invocation
//        ButterKnife.bind(this);
//    }
    @OnClick(R.id.bu_qie)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
             break;
            case R.id.bu_qie:
                mPrenter.getString();
            break;
    }
}
}
