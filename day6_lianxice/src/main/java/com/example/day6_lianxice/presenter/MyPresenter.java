package com.example.day6_lianxice.presenter;

import com.example.day6_lianxice.base.BasePresenter;
import com.example.day6_lianxice.bean.MyBean;
import com.example.day6_lianxice.callback.MyCallBack;
import com.example.day6_lianxice.mdoel.MyModel;
import com.example.day6_lianxice.view.MyView;

public class MyPresenter extends BasePresenter<MyView> implements MyCallBack {


    private MyModel myModel;

    @Override
    protected void inidPresenter() {
        myModel = new MyModel();
       addModelse(myModel);
    }

    public void setString(){
        myModel.getData(this);
    }
    @Override
    public void onSuner(MyBean myBean) {
        mView.setData(myBean);
    }

    @Override
    public void onFail(String str) {
        mView.showToast(str);
    }
}
