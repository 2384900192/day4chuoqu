package com.example.day2_chouqu.base;

import com.example.day2_chouqu.net.MyCallBack;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {

    public CompositeDisposable mDisposable=null;

    public void addModel(Disposable disposable){
        if (mDisposable==null){
            synchronized (BaseModel.class){
                if (mDisposable==null)
                    mDisposable=new CompositeDisposable();
            }
        }
        mDisposable.add(disposable);
    }
    public void dispose(){
        mDisposable.dispose();
    }
    public void removeDisposable(Disposable disposable){
        if (mDisposable!=null);
        mDisposable.remove(disposable);
//        mDisposable=null;
    }
}
