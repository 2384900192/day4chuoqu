package com.example.day1_chouqu.utils;

import android.widget.Toast;

import com.example.day1_chouqu.callback.BaseApp;


public class ToastUtil {
    public static void showShort(String msg){
        Toast.makeText(BaseApp.sBaseApp,msg,Toast.LENGTH_SHORT).show();
    }
    public static void showLong(String msg){
        Toast.makeText(BaseApp.sBaseApp,msg,Toast.LENGTH_LONG).show();
    }
}
