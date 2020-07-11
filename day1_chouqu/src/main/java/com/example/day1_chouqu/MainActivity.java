package com.example.day1_chouqu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.day1_chouqu.base.BaseActivity;
import com.example.day1_chouqu.prenter.MyPrenter;
import com.example.day1_chouqu.view.MyView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MyPrenter> implements MyView {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.bu_dian)
    Button buDian;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//    }

    @Override
    protected void initView() {
        tvName.setText("ssr");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initPresenter() {
        mPresenter=new MyPrenter();
    }

    @Override
    protected int getLayout() {//设置此页面用的布局
        return R.layout.activity_main;
    }

    @OnClick(R.id.bu_dian)
    public void onViewClicked() {
        mPresenter.getString();
    }

    @Override
    public void setData(String str) {
        tvName.setText(str);
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
