package com.example.day4_lianxice;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.day4_lianxice.activity.ShouActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_huanying)
    TextView tvHuanying;
    int post=2;
    Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            //tvHuanying.setText(post+"");
            if (post==0){
                Intent intent = new Intent(MainActivity.this, ShouActivity.class);
                startActivity(intent);
//                finish();
            }
            return false;
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (post>0){
                    try {
                        Thread.sleep(1000);
                        handler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    post--;
                }
            }
        }).start();
    }


}
