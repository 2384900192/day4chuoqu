package com.example.day2_chouqu.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.day2_chouqu.R;
import com.example.day2_chouqu.adapter.MyAdapter;
import com.example.day2_chouqu.base.BaseFragment;
import com.example.day2_chouqu.bean.MyBean;
import com.example.day2_chouqu.presenter.MyPresenter;
import com.example.day2_chouqu.view.MyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ShowFragment extends BaseFragment<MyPresenter> implements MyView {
    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    private List<MyBean.ResultsBean> list;
    private MyAdapter myAdapter;
    @Override
    protected void initView() {
        mPresenter.getString();
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(getActivity(), list);
        mRecycler.setAdapter(myAdapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_shou;

    }

    @Override
    protected void initPresenter() {
        mPresenter=new MyPresenter();
    }

    @Override
    public void onDiserp(MyBean myBean) {
        if(myBean != null && myBean.getResults() != null){
            list.addAll(myBean.getResults());
            myAdapter .notifyDataSetChanged();
        }
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }
}
