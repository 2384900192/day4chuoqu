package com.example.day1_chouqu.model;

import com.example.day1_chouqu.api.ApiServer;
import com.example.day1_chouqu.base.BaseModel;
import com.example.day1_chouqu.base.BaseObserver;
import com.example.day1_chouqu.bean.MyBean;
import com.example.day1_chouqu.callback.StrCallBack;
import com.example.day1_chouqu.utils.HttpUtils;
import com.example.day1_chouqu.utils.RxUtils;

import io.reactivex.Observable;


public class MyModel extends BaseModel {

    public void getData(StrCallBack strCallBack){
        try{
            String str="萨嘎了解对方和";
//            strCallBack.onSuccess(str);
        }catch (Exception e){
            e.printStackTrace();
            strCallBack.onFail(e.getMessage());
        }
    }
    public void getMyBean(final StrCallBack strCallBack){
        ApiServer apiserver = HttpUtils.getInstance().getApiserver(ApiServer.url, ApiServer.class);
        Observable<MyBean> data = apiserver.getData();
        data.compose(RxUtils.<MyBean>rxObserableSchedulerHelper())
               .subscribe(new BaseObserver<MyBean>(this) {
                   @Override
                   protected void onSuccess(MyBean myBean) {
                       strCallBack.onSuccess(myBean);
                   }

                   @Override
                   protected void error(String err) {
                        strCallBack.onFail(err);
                   }
               });

//        Retrofit build = new Retrofit.Builder()
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
//                        addDispose(d);
//                    }
//
//                    @Override
//                    public void onNext(MyBean myBean) {
//                        strCallBack.onSuccess(myBean);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        strCallBack.onFail(e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }
}
