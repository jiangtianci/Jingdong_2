package com.example.jing_dong.fenlei;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.jing_dong.Api_fenlei.Bean_chuan2;
import com.example.jing_dong.Api_fenlei.Bean_chuan3;
import com.example.jing_dong.Api_fenlei.Bean_fen;
import com.example.jing_dong.F2_presenter.Shoupresenter_fen;
import com.example.jing_dong.F2_view.Iview_fen;
import com.example.jing_dong.R;
import com.example.jing_dong.adaper.Fen_adaper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 */

public class Fenlei_1 extends AppCompatActivity implements Iview_fen{

    private String pscid;
    private RecyclerView fen_rv;
    private List<Bean_fen.DataBean> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenlei_tiao);
        //隐藏标题栏
        getSupportActionBar().hide();

        EventBus.getDefault().register(this);
        fen_rv = findViewById(R.id.fen_rv);
        Shoupresenter_fen shoupresenter_fen = new Shoupresenter_fen(this);
        shoupresenter_fen.getmythis_fen(pscid);



    }

    @Override
    public void getiview_fen(Bean_fen bean_fen) {
        list = bean_fen.getData();
        Fen_adaper fen_adaper = new Fen_adaper(this, list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        fen_rv.setLayoutManager(manager);
        fen_rv.setAdapter(fen_adaper);

        fen_adaper.setSetonClick(new Fen_adaper.SetonClick() {
            @Override
            public void setOnclick(int position) {
                Intent intent = new Intent(Fenlei_1.this,Fenlei_xiangqing.class);
                startActivity(intent);
                String pid = list.get(position).getPid();
                EventBus.getDefault().postSticky(new Bean_chuan3(pid));
            }
        });


    }
    //接受传值
    @Subscribe(sticky =  true,threadMode = ThreadMode.MAIN)
    public void getbean(Bean_chuan2 bean) {
        pscid = bean.getPscid();

        Log.i("ccccccccccccccc",pscid);


    }

    //反注册
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
