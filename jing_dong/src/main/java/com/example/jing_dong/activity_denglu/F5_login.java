package com.example.jing_dong.activity_denglu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jing_dong.R;
import com.example.jing_dong.activity_denglu.modl.LoBean;
import com.example.jing_dong.activity_denglu.presenter.Loshoupresenter;
import com.example.jing_dong.activity_denglu.view.Loiview;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2017/11/14.
 */

public class F5_login extends AppCompatActivity implements View.OnClickListener,Loiview{

    private EditText et_name;
    private EditText et_pass;
    private String code;
    private String msg;
    private String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.th_my_loag_avtivity);
        //隐藏标题栏
        getSupportActionBar().hide();
        //控件
        initKong();

    }
    //控件
    private void initKong() {
        ImageView im_tui = (ImageView) findViewById(R.id.im_tui);
        TextView tv_zhuce = (TextView) findViewById(R.id.tv_zhuce);
        et_name = (EditText) findViewById(R.id.user_name);
        et_pass = (EditText) findViewById(R.id.user_pwd);
        Button bt_deng = (Button) findViewById(R.id.bt_deng);
        bt_deng.setOnClickListener(this);
        tv_zhuce.setOnClickListener(this);
        im_tui.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.im_tui :
                finish();
                break;
            //注册
            case R.id.tv_zhuce:
                Intent intent = new Intent(F5_login.this,F5_zhuce.class);
                startActivity(intent);
                break;
            //登陆按钮
            case R.id.bt_deng:
                name = et_name.getText().toString().trim();
                String pass = et_pass.getText().toString().trim();

                Loshoupresenter loshoupresenter = new Loshoupresenter(this, name,pass);
                loshoupresenter.getimodl();


                break;
        }
    }

    @Override
    public void getLoiview(final LoBean loBean) {
        runOnUiThread(new Runnable() {

            private String id;

            @Override
            public void run() {
                String s = loBean.toString();
                code = loBean.getCode();
                msg = loBean.getMsg();
                int uid = loBean.getData().getUid();

                id = String.valueOf(uid);

                //Toast.makeText(F5_login.this, "222"+ msg, Toast.LENGTH_SHORT).show();
                if (code.indexOf("0")!=-1){
                    Toast.makeText(F5_login.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    EventBus.getDefault().postSticky(new Chuan_bean(name,id));
                    finish();
                }else {
                    Toast.makeText(F5_login.this, "登陆失败", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
