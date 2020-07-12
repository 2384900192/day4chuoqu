package com.example.day4_lianxice.base;

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
        this.mView=v;
    }

    public void destroy(){
        mView=null;
        for (int i = 0; i < models.size(); i++) {
            BaseModel baseModel = models.get(i);
            baseModel.dispose();
        }
    }
}
