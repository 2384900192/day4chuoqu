package com.example.day6_lianxice.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView> {
    public V mView;
    private ArrayList<BaseModel> models=new ArrayList<>();
    public BasePresenter(){
        inidPresenter();
    }

    protected abstract void inidPresenter();
    public void addModelse(BaseModel baseModel){
        models.add(baseModel);
    }
    public void bindView( V v){
        mView=v;
    }
    public void destroy(){
        mView=null;
        for (int i = 0; i < models.size(); i++) {
            models.get(i).dispose();
        }
    }
}
