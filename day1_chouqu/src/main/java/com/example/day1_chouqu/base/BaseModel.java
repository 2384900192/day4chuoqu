package com.example.day1_chouqu.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {

    private CompositeDisposable mDispos=null;

    public void addDispose(Disposable disposable){
        if (mDispos==null){
            synchronized (BaseModel.class){
                if (mDispos==null){
                    mDispos=new CompositeDisposable();
                }
            }
        }
        mDispos.add(disposable);
    }
    public void dispose(){
        mDispos.dispose();
    }
    public void removeDispose(Disposable disposable){

        if (mDispos!=null){
            mDispos.remove(disposable);
        }
    }
}
