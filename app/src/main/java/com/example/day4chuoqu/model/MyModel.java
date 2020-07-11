package com.example.day4chuoqu.model;

import com.example.day4chuoqu.base.BaseModel;
import com.example.day4chuoqu.callback.StrCallBack;

public class MyModel extends BaseModel {

    public void getData(StrCallBack strCallBack){
        try{
            String str="请求数据-切换";
            strCallBack.onSuccess(str);
        }catch (Exception e){
            e.printStackTrace();
            strCallBack.onFail(e.getMessage());
        }
    }
}
