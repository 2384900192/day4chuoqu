package com.example.day5_lianxi.presenter;

import com.example.day5_lianxi.base.BasePresenter;
import com.example.day5_lianxi.bean.MyBean;
import com.example.day5_lianxi.callback.MyCallBack;
import com.example.day5_lianxi.model.MyModel;
import com.example.day5_lianxi.view.MyView;

public class MyPresenter extends BasePresenter<MyView> implements MyCallBack {


    private MyModel myModel;

    @Override
    protected void initPresenter() {
        myModel = new MyModel();
        addModel(myModel);
    }
    public void getString(){
        myModel.getData(this);
    }

    @Override
    public void onSuuenter(MyBean myBean) {
        mView.setData(myBean);
    }

    @Override
    public void onFail(String str) {
        mView.showToast(str);
    }
}
