package com.example.day2_chouqu.presenter;

import com.example.day2_chouqu.base.BasePresenter;
import com.example.day2_chouqu.bean.MyBean;
import com.example.day2_chouqu.model.MyModel;
import com.example.day2_chouqu.net.MyCallBack;
import com.example.day2_chouqu.view.MyView;

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
    public void onSunert(MyBean myBean) {
        mView.onDiserp(myBean);
    }

    @Override
    public void onFile(String str) {
        mView.showToast(str);
    }
}
