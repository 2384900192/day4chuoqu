package com.example.day1_chouqu.base;

import java.util.ArrayList;

public abstract class BasePrenter<V extends BaseView> {

    public V mView;
    private ArrayList<BaseModel> models=new ArrayList<>();

    public BasePrenter(){
        initModel();
    }

    protected abstract void initModel();
    public void addModel(BaseModel baseModel){
        models.add(baseModel);
    }
    public void bindView(V v){//绑定view，给mView赋值
        this.mView = v;
    }

    public void destroy(){//view销毁时，调用p的销毁，解除p和view的关系，p和model的关系，停止网络请求
        mView = null;//p销毁，mView也可以等于空，用不着了
        for (int i = 0; i < models.size(); i++) {
            BaseModel baseModel = models.get(i);
            baseModel.dispose();//p销毁，baseModel也可以销毁，用不着了，-销毁网络请求
        }
    }
}
