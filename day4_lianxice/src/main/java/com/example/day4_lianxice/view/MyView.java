package com.example.day4_lianxice.view;

import com.example.day4_lianxice.base.BaseView;
import com.example.day4_lianxice.bean.MyBean;

import java.util.List;

public interface MyView extends BaseView {
    void setData(List<MyBean> list);
}
