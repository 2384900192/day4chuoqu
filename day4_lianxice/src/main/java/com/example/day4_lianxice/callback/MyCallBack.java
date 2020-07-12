package com.example.day4_lianxice.callback;

import com.example.day4_lianxice.bean.MyBean;

import java.util.List;

public interface MyCallBack {
    void onServer(List<MyBean> list);
    void onFail(String str);
}
