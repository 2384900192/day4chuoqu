package com.example.day5_lianxi.model;

import android.annotation.SuppressLint;

import com.example.day5_lianxi.base.BaseModel;
import com.example.day5_lianxi.bean.MyBean;
import com.example.day5_lianxi.callback.ApiServer;
import com.example.day5_lianxi.callback.MyCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel extends BaseModel {
    @SuppressLint("CheckResult")
    public void getData(final MyCallBack myCallBack){
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiServer.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiServer apiServer = build.create(ApiServer.class);
        Observable<MyBean> data = apiServer.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addModels(d);
                    }

                    @Override
                    public void onNext(MyBean myBean) {
                        myCallBack.onSuuenter(myBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
