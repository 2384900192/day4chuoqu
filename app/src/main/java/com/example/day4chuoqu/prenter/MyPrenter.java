package com.example.day4chuoqu.prenter;

import com.example.day4chuoqu.base.BasePrenter;
import com.example.day4chuoqu.callback.StrCallBack;
import com.example.day4chuoqu.model.MyModel;
import com.example.day4chuoqu.view.MyView;

public class MyPrenter extends BasePrenter<MyView> implements StrCallBack {
    private MyModel myModel;

    @Override
    protected void initModel() {
        myModel=new MyModel();
        addModel(myModel);
    }

    public void getString(){
        myModel.getData(this);
    }

    @Override
    public void onSuccess(String str) {
        mView.setData(str);
    }

    @Override
    public void onFail(String str) {
        mView.showToast(str);
    }
}
