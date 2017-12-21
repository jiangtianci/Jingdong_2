package com.example.jing_dong.activity_denglu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jing_dong.R;
import com.example.jing_dong.activity_denglu.modl.ZBean;
import com.example.jing_dong.activity_denglu.presenter.ZShoupresenter;
import com.example.jing_dong.activity_denglu.view.Ziview;

/**
 * Created by Administrator on 2017/11/14.
 */

public class F5_zhuce extends AppCompatActivity implements Ziview{

    private EditText ed_name;
    private EditText ed_pass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registered_activity);
        //隐藏标题栏
        getSupportActionBar().hide();
        ImageView im_guan = (ImageView) findViewById(R.id.im_zu_guan);
        ed_name = (EditText) findViewById(R.id.zu_name);
        ed_pass = (EditText) findViewById(R.id.zhu_pass);
        Button bt_zhu = (Button) findViewById(R.id.bt_zhu);
        //注册按钮
        bt_zhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ed_name.getText().toString().trim();
                String pass = ed_pass.getText().toString().trim();
                ZShoupresenter zShoupresenter = new ZShoupresenter(F5_zhuce.this,name,pass);
                zShoupresenter.getiview();
            }
        });

        im_guan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void getziview(final ZBean zBean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String code = zBean.getCode();
                String msg = zBean.getMsg();
                if (code.indexOf("0")!=-1){
                    System.out.println("msg+code = " + msg + code);
                    Toast.makeText(F5_zhuce.this, ""+msg, Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(F5_zhuce.this, ""+msg, Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}
