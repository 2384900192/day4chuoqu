package com.example.day4_lianxice.model;

import com.example.day4_lianxice.R;
import com.example.day4_lianxice.base.BaseModel;
import com.example.day4_lianxice.bean.MyBean;
import com.example.day4_lianxice.callback.MyCallBack;

import java.util.ArrayList;
import java.util.List;

public class MyModel extends BaseModel {
    public void getData(MyCallBack myCallBack){
        List<MyBean> list=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MyBean myBean = new MyBean(Long.parseLong(i + ""), "李四" + i, "1909B", "https://ww1.sinaimg.cn/large/0065oQSqgy1ftwcw4f4a5j30sg10j1g9.jpg");
            list.add(myBean);
        }
    }
}
