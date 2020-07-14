package com.example.day6_lianxice.callback;

import com.example.day6_lianxice.bean.MyBean;

public interface MyCallBack {
    void onSuner(MyBean myBean);
    void onFail(String str);
}
