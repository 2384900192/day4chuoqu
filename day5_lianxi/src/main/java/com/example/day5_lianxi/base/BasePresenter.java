package com.example.day5_lianxi.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView> {
    public V mView;
    private ArrayList<BaseModel> models=new ArrayList<>();

    public BasePresenter(){
        initPresenter();
    }

    protected abstract void initPresenter();
    public void addModel(BaseModel baseModel){
        models.add(baseModel);
    }
    public void bindView(V v){
        mView=v;
    }

    public void destory(){
        mView=null;
        for (int i = 0; i < models.size(); i++) {
            models.get(i).disposet();
        }
    }
}
