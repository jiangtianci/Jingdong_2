package com.example.jing_dong;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by Administrator on 2017/11/15.
 */

public class Sou_webview extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);
        //隐藏标题栏
        getSupportActionBar().hide();
        WebView wb = (WebView) findViewById(R.id.wb);
        Intent intent = getIntent();
        String name1 = intent.getStringExtra("url");
        WebSettings settings = wb.getSettings();
        settings.setAllowFileAccess(true);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        wb.loadUrl(name1);
        System.out.println("==========="+name1);
    }
}
