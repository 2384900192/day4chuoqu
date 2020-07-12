package com.example.day1_chouqu.callback;

import com.example.day1_chouqu.bean.MyBean;

public interface StrCallBack {
    void onSuccess(MyBean myBean);
    void onFail(String str);
}
