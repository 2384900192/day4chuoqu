package com.example.day4chuoqu.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    private CompositeDisposable compositeDisposable=null;

    public void addData(Disposable disposable){
      if (compositeDisposable==null){
          synchronized (BaseModel.class){
              if (compositeDisposable==null){
                  compositeDisposable=new CompositeDisposable();
              }
          }
      }
      compositeDisposable.add(disposable);
    }
    public void dispose(){
        compositeDisposable.dispose();
    }
    public void removeDispose(Disposable disposable){
        if (compositeDisposable!=null){
            compositeDisposable.remove(disposable);
        }
    }
}
