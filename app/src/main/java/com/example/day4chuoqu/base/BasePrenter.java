package com.example.day4chuoqu.base;

import java.util.ArrayList;

public abstract class BasePrenter<V extends BaseView> {
    public V mView;
    private ArrayList<BaseModel> mModel=new ArrayList<>();

    public BasePrenter(){
        initModel();
    }

    protected abstract void initModel();
    public void addModel(BaseModel baseModel){
        mModel.add(baseModel);
    }
    public void bindView(V v){
        this.mView=v;
    }
    public void destroy(){
        mView=null;
        for (int i = 0; i < mModel.size(); i++) {
            BaseModel baseModel = mModel.get(i);
            baseModel.dispose();
        }
    }
}
