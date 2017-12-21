package com.example.jing_dong;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jing_dong.Sou_modl.Sou_Bean;
import com.example.jing_dong.Sou_presenter.Sou_shoupresenter;
import com.example.jing_dong.Sou_view.Sou_Iview;
import com.example.jing_dong.adaper.Sou_adaper;

import java.util.List;

/**
 * Created by Administrator on 2017/11/10.
 */

public class Sousuo extends AppCompatActivity implements Sou_Iview{

    private RecyclerView sou_rv;
    private List<Sou_Bean.DataBean> list;
    String name;
    private EditText ed_sou;
    private Sou_shoupresenter shoupresenter;
    private CheckBox im_lan;
    private boolean panduan =false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sousuo);
        //隐藏标题栏
        getSupportActionBar().hide();
        //控件
        ImageView im_sou = (ImageView) findViewById(R.id.im_sou);
        ed_sou = (EditText) findViewById(R.id.ed_sou);
        im_lan = (CheckBox) findViewById(R.id.im_sou_lan);
        TextView tv_sou  = (TextView) findViewById(R.id.tv_sou);
        sou_rv = (RecyclerView) findViewById(R.id.sou_rv);



        //im_sou监听事件
        im_sou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        shoupresenter = new Sou_shoupresenter(Sousuo.this);
        //点击搜索
        tv_sou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = ed_sou.getText().toString().trim();
                shoupresenter.Sou_p_name(name);
            }
        });
        im_lan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (im_lan.isChecked()){
                    GridLayoutManager manager = new GridLayoutManager(Sousuo.this,2);
                    Sou_adaper adaper = new Sou_adaper(Sousuo.this,list);
                    sou_rv.setLayoutManager(manager);
                    sou_rv.setAdapter(adaper);
                    adaper.setOnItemClickListener(new Sou_adaper.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            String url = list.get(position).getDetailUrl();
                            Intent intent = new Intent(Sousuo.this,Sou_webview.class);
                            intent.putExtra("url",url);
                            //intent.putExtra("name",list.get(i).getUrl());
                            startActivity(intent);
                        }
                    });
                }else {
                    LinearLayoutManager manager = new LinearLayoutManager(Sousuo.this);
                    Sou_adaper adaper = new Sou_adaper(Sousuo.this,list);
                    sou_rv.setLayoutManager(manager);
                    sou_rv.setAdapter(adaper);
                    adaper.setOnItemClickListener(new Sou_adaper.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            String url = list.get(position).getDetailUrl();
                            Intent intent = new Intent(Sousuo.this,Sou_webview.class);
                            intent.putExtra("url",url);
                            //intent.putExtra("name",list.get(i).getUrl());
                            startActivity(intent);
                        }
                    });
                }
            }
        });

    }


    //MVP
    @Override
    public void sou_iview(Sou_Bean sou_bean) {
          list = sou_bean.getData();
          Log.i("cccc",list.get(0).getTitle());

          LinearLayoutManager manager = new LinearLayoutManager(Sousuo.this);
          //绑定适配器
          Sou_adaper adaper = new Sou_adaper(Sousuo.this,list);
          sou_rv.setLayoutManager(manager);
          sou_rv.setAdapter(adaper);

           adaper.setOnItemClickListener(new Sou_adaper.OnItemClickListener() {
               @Override
               public void onItemClick(View view, int position) {
                   String url = list.get(position).getDetailUrl();
                   Intent intent = new Intent(Sousuo.this,Sou_webview.class);
                   intent.putExtra("url",url);
                   //intent.putExtra("name",list.get(i).getUrl());
                   startActivity(intent);
               }
           });





    }


}
