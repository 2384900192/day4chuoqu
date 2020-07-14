package com.example.day_zdyview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class SpinnerView extends RelativeLayout {

    private EditText mTextEt;
    private ImageView mImgerIv;
    private ArrayList<String> list;
    private PopupWindow window;

    //必须有的构造
    public SpinnerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.spinner, this);
        initView(inflate);
        initData();
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("班级"+i);
        }
    }

    private void initView(@NonNull final View itemView) {
        mTextEt = (EditText) itemView.findViewById(R.id.et_text);
        mImgerIv = (ImageView) itemView.findViewById(R.id.iv_imger);

        mImgerIv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showPop();
            }
        });
    }

    private void showPop() {
        //判断是否为空,实现PopupWindow复用
        if (window==null){
            window = new PopupWindow(mTextEt.getWidth(), 400);
            ListView listView = new ListView(getContext());
            listView.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,list));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String s = list.get(position);
                    mTextEt.setText(s);
                    //将光标移动到某个位置
                    mTextEt.setSelection(s.length());
                    window.dismiss();
                }
            });
            //PopupWindow三要素之View
            window.setContentView(listView);
            window.setBackgroundDrawable(new ColorDrawable());
            window.setOutsideTouchable(true);
            window.setFocusable(true);
        }
            window.showAsDropDown(mTextEt);
    }


}
