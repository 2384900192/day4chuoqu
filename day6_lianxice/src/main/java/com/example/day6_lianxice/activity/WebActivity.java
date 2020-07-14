package com.example.day6_lianxice.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.day6_lianxice.R;

public class WebActivity extends AppCompatActivity {

    private TextView mTextToolbar;
    private Toolbar mWebToolbar;
    private WebView mWebWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
    }

    private void initView() {
        mTextToolbar = (TextView) findViewById(R.id.toolbar_text);
        mWebToolbar = (Toolbar) findViewById(R.id.toolbar_web);
        mWebWeb = (WebView) findViewById(R.id.web_web);


        Intent intent = getIntent();
        String link = intent.getStringExtra("link");
        String desc = intent.getStringExtra("desc");

        mWebWeb.loadUrl(link);
        mWebWeb.setWebChromeClient(new WebChromeClient());
        mWebToolbar.setTitle("");
        setSupportActionBar(mWebToolbar);

        mTextToolbar.setText(desc);
        mTextToolbar.setSelected(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mWebToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
