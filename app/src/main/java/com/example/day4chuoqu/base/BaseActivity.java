package com.example.day4chuoqu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePrenter> extends AppCompatActivity implements BaseView {

    public P mPrenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initPrenter();
        if (mPrenter!=null){
            mPrenter.bindView(this);
        }
        initView();
        initData();
        initListener();
    }

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract void initView();

    protected abstract void initPrenter();

    protected abstract int getLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPrenter!=null){
            mPrenter.destroy();
            mPrenter=null;
        }
    }
}
