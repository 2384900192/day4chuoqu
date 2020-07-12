package com.example.day2_chouqu;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.day2_chouqu.adapter.MainAdapter;
import com.example.day2_chouqu.fragment.ShowFragment;
import com.example.day2_chouqu.fragment.WebFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ViewPager mViewpager;
    private TabLayout mTablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mTablayout = (TabLayout) findViewById(R.id.tablayout);
        List<Fragment> list=new ArrayList<>();
        list.add(new ShowFragment());
        list.add(new WebFragment());
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager(), list);
        mViewpager.setAdapter(mainAdapter);
        mTablayout.setupWithViewPager(mViewpager);
        mTablayout.getTabAt(0).setText("首页");
        mTablayout.getTabAt(1).setText("网页");
    }
}
