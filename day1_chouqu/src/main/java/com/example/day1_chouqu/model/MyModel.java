package com.example.day1_chouqu.model;

import com.example.day1_chouqu.base.BaseModel;
import com.example.day1_chouqu.callback.StrCallBack;

public class MyModel extends BaseModel {

    public void getData(StrCallBack strCallBack){
        try{
            String str="萨嘎了解对方和";
            strCallBack.onSuccess(str);
        }catch (Exception e){
            e.printStackTrace();
            strCallBack.onFail(e.getMessage());
        }
    }
}
