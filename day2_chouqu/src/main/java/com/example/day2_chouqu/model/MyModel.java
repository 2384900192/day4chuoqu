package com.example.day2_chouqu.model;

import com.example.day2_chouqu.base.BaseModel;
import com.example.day2_chouqu.bean.MyBean;
import com.example.day2_chouqu.net.ApiServer;
import com.example.day2_chouqu.net.BaseObserver;
import com.example.day2_chouqu.net.MyCallBack;
import com.example.day2_chouqu.utils.HttpUtils;
import com.example.day2_chouqu.utils.RxUtils;

import io.reactivex.Observable;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel extends BaseModel {

    public void getData(final MyCallBack myCallBack){
        ApiServer apiserver = HttpUtils.getInstance().getApiserver(ApiServer.url, ApiServer.class);
        Observable<MyBean> observable = apiserver.getData();
//compose 简化线程切换
        observable.compose(RxUtils.<MyBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<MyBean>(this) {
                    @Override
                    protected void onSuccess(MyBean myBean) {
                        myCallBack.onSunert(myBean);
                    }

                    @Override
                    protected void error(String err) {
                        myCallBack.onFile(err);
                    }
                });
//            Retrofit build = new Retrofit.Builder()
//                .baseUrl(ApiServer.url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//        ApiServer apiServer = build.create(ApiServer.class);
//        Observable<MyBean> data = apiServer.getData();
//        data .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<MyBean>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addModel(d);
//                    }
//
//                    @Override
//                    public void onNext(MyBean myBean) {
//                        myCallBack.onSunert(myBean);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        myCallBack.onFile(e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }
}
