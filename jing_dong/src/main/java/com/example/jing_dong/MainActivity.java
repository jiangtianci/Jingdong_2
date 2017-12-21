package com.example.jing_dong;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.zhy.autolayout.AutoLayoutActivity;


public class MainActivity extends AutoLayoutActivity{


    int miao = 2;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            miao--;
            if (miao==0){

                Intent intent = new Intent(MainActivity.this,Jingdong.class);
                startActivity(intent);
                finish();
            }
            sendEmptyMessageDelayed(0,1000);


        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //隐藏标题栏
        getSupportActionBar().hide();
        handler.sendEmptyMessage(0);

    }
}
