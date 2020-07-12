package com.example.day1_chouqu;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.day1_chouqu.adapter.MyAdapter;
import com.example.day1_chouqu.base.BaseActivity;
import com.example.day1_chouqu.bean.MyBean;
import com.example.day1_chouqu.prenter.MyPrenter;
import com.example.day1_chouqu.view.MyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MyPrenter> implements MyView {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.bu_dian)
    Button buDian;
    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    private List<MyBean.ResultsBean> list;
    private MyAdapter myAdapter;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//    }

    @Override
    protected void initView() {
        tvName.setText("ssr");
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        mRecycler.setAdapter(myAdapter);
    }

    @Override
    protected void initData() {
        int i = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (i != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
        }
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

//    @Override
//    public void setData(String str) {
//        tvName.setText(str);
//    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(MyBean str) {
        if(str != null && str.getResults() != null){
            list.addAll(str.getResults());
            myAdapter .notifyDataSetChanged();
        }
    }
}
