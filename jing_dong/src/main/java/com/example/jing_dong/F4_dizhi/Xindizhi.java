package com.example.jing_dong.F4_dizhi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jing_dong.Dizhi_bean.Dizhi_bean_tjbean;
import com.example.jing_dong.Dizhi_presenter.Tj_shoupresenter;
import com.example.jing_dong.Dizhi_view.Tj_iview;
import com.example.jing_dong.R;
import com.example.jing_dong.activity_denglu.Chuan_bean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2017/12/15.
 */

public class Xindizhi extends AppCompatActivity implements View.OnClickListener,Tj_iview {

    private String id;
    private EditText ed_dizhi_addr;
    private EditText ed_shouji_mobile;
    private EditText ed_name;
    private String token;
    private String addr;
    private String mobile;
    private String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xindizhi);

        initKongjian();
        EventBus.getDefault().register(this);
    }

    private void initKongjian() {
        ImageView im_tui = findViewById(R.id.xindizhi_tui_im);
        ed_name = findViewById(R.id.xindizhi_name);
        ed_shouji_mobile = findViewById(R.id.xindizhi_shouji);
        ed_dizhi_addr = findViewById(R.id.xindizhi_xiangxidizhi);
        Button bt_tijiao = findViewById(R.id.xindizhi_bt);


        bt_tijiao.setOnClickListener(this);
        im_tui.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.xindizhi_tui_im:
                finish();
                break;

            case R.id.xindizhi_bt:
                mobile = ed_shouji_mobile.getText().toString().trim();
                addr = ed_dizhi_addr.getText().toString().trim();
                name = ed_name.getText().toString().trim();
                Tj_shoupresenter tj_shoupresenter = new Tj_shoupresenter(this,id,addr,mobile,name,token );
                tj_shoupresenter.getmytj_this();
                Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show();

                break;
        }
    }

    @Override
    public void getmytj_ivew(Dizhi_bean_tjbean tjbean) {
        String code = tjbean.getCode();


        if (code!= null){
            Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
        }

        Log.i("cccccccccc",code);



    }
    //接受传值
    @Subscribe(sticky =  true,threadMode = ThreadMode.MAIN)
    public void getbean(Chuan_bean bean) {
        token = bean.getName();
        id = bean.getId();
        Toast.makeText(this, "Id"+id, Toast.LENGTH_SHORT).show();
        Log.i("cccccccccctoken",token);
        Log.i("ccccccccccid",id);
    }
    //反注册
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
