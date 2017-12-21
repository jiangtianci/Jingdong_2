package com.example.jing_dong.F4_dizhi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jing_dong.R;

/**
 * Created by Administrator on 2017/12/14.
 */

public class Dizhi_class extends AppCompatActivity implements View.OnClickListener{

    private ImageView im_zhidi_tui1;
    private TextView dizhi_tv_xingming1;
    private TextView dizhi_tv_dianhua1;
    private TextView tv_dizhi1;
    private RelativeLayout rl_dizhi_tianjia1;
    private TextView tv_dizhi_jia1;
    private TextView tv_dizhi_zhifu1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dingdan_item);

        initKongjian();





    }



    private void initKongjian() {
        im_zhidi_tui1 = findViewById(R.id.im_dizhi_tui);
        dizhi_tv_xingming1 = findViewById(R.id.dizhi_tv_xingming);
        dizhi_tv_dianhua1 = findViewById(R.id.dizhi_tv_dianhua);
        tv_dizhi1 = findViewById(R.id.tv_dizhi);
        rl_dizhi_tianjia1 = findViewById(R.id.rl_dizhi_tianjia);
        tv_dizhi_jia1 = findViewById(R.id.tv_dizhi_jia);
        tv_dizhi_zhifu1 = findViewById(R.id.tv_dizhi_zhifu);
        im_zhidi_tui1.setOnClickListener(this);
        rl_dizhi_tianjia1.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_dizhi_tui:
                    finish();
                break;
            case R.id.dizhi_tv_xingming:
                break;
            case R.id.dizhi_tv_dianhua:
                break;
            case R.id.tv_dizhi:
                break;
            case R.id.rl_dizhi_tianjia:
                Intent intent = new Intent(this,Tianjia.class);
                startActivity(intent);
                break;
            case R.id.tv_dizhi_jia:
                break;
            case R.id.tv_dizhi_zhifu:
                break;
        }
    }

}
