package com.example.jing_dong.F4_dizhi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.jing_dong.Dizhi_bean.Dizhi_bean_tjbean;
import com.example.jing_dong.Dizhi_presenter.Tj_shoupresenter;
import com.example.jing_dong.Dizhi_view.Tj_iview;
import com.example.jing_dong.R;
import com.example.jing_dong.activity_denglu.Chuan_bean;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2017/12/15.
 */

public class Tianjia extends AppCompatActivity implements View.OnClickListener{

    private ImageView im_tianjia_tui;
    private ListView lv;
    private Button bt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tianjia_dizhi);
            initKongjian();




    }

    private void initKongjian() {
        im_tianjia_tui = findViewById(R.id.tianjia_im_tui);
        lv = findViewById(R.id.tianjia_list);
        bt = findViewById(R.id.tianjia_bt);
        im_tianjia_tui.setOnClickListener(this);
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tianjia_im_tui:
                finish();
                break;
            case R.id.tianjia_bt:
                Intent intent = new Intent(this,Xindizhi.class);
                startActivity(intent);
                break;
        }
    }


}
