package com.example.day1_chouqu.prenter;

import com.example.day1_chouqu.base.BasePrenter;
import com.example.day1_chouqu.callback.StrCallBack;
import com.example.day1_chouqu.model.MyModel;
import com.example.day1_chouqu.view.MyView;

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
