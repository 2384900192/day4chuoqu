package com.example.day4_lianxice.presenter;

import com.example.day4_lianxice.base.BasePresenter;
import com.example.day4_lianxice.bean.MyBean;
import com.example.day4_lianxice.callback.MyCallBack;
import com.example.day4_lianxice.model.MyModel;
import com.example.day4_lianxice.view.MyView;

import java.util.List;

public class MyPresenter extends BasePresenter<MyView> implements MyCallBack {


    private MyModel myModel;

    @Override
    protected void initPresenter() {
        myModel = new MyModel();
        addModel(myModel);
    }

    @Override
    public void onServer(List<MyBean> list) {
        mView.setData(list);
    }

    @Override
    public void onFail(String str) {
        mView.showToast(str);
    }
}
