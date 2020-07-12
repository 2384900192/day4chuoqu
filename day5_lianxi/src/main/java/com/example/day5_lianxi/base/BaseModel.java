package com.example.day5_lianxi.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {

    public CompositeDisposable mDisposable=null;

    public void addModels(Disposable disposable){
        if (mDisposable==null){
            synchronized (BaseModel.class){
                if (mDisposable==null)
                    mDisposable=new CompositeDisposable();
            }
        }
        mDisposable.add(disposable);
    }

    public void disposet(){
        mDisposable.dispose();
    }
    public void removeDisposable(Disposable disposable){
        if (mDisposable!=null){
            mDisposable.remove(disposable);
        }
    }
}
