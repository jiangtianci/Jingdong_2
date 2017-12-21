package com.example.jing_dong.fenlei;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jing_dong.Api_fenlei.Bean_chuan3;
import com.example.jing_dong.Api_fenlei.Bean_xiangqing;
import com.example.jing_dong.F2_presenter.Shoupresenter_xiangqing;
import com.example.jing_dong.F2_view.Iview_xianqing;
import com.example.jing_dong.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 */

public class Fenlei_xiangqing extends AppCompatActivity implements Iview_xianqing{

    private TextView tv_title;
    private TextView tv_price;
    private TextView tv_text;
    private String pid;
    private Banner bann;
    int a = 0;
    private List<String> im_list;
    private Bean_xiangqing.DataBean data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenlei_xiangqing);
        //隐藏标题栏
        getSupportActionBar().hide();

        EventBus.getDefault().register(this);
        bann = findViewById(R.id.detail_banner);
        tv_title = findViewById(R.id.details_title);
        tv_price = findViewById(R.id.details_price);
        tv_text = findViewById(R.id.details_text);


        Shoupresenter_xiangqing xiangqing = new Shoupresenter_xiangqing(this);
       xiangqing.getmythis(pid);

    }



    @Override
    public void getmyiview_xiangqing(Bean_xiangqing bean_xiangqing) {
        data = bean_xiangqing.getData();
        tv_title.setText(data.getTitle());
        tv_price.setText(data.getPrice()+"");
        tv_text.setText("￥"+data.getSubhead()+"");

        String[] split = data.getImages().split("\\|");

        im_list = new ArrayList<>();
        for (int i = 0; i <split.length ; i++) {
            im_list.add(split[i]);
        }
//        for (String str: split) {
//            im_list.add(str);
//            a++;
//        }

        bann.setImageLoader(new jiexi());
        //设置图片集合
        bann.setImages(im_list);
        bann.start();




    }


    //接受传值
    @Subscribe(sticky =  true,threadMode = ThreadMode.MAIN)
    public void getbean(Bean_chuan3 bean) {

        pid = bean.getPid();

        Log.i("ccccccccccccccc22222", pid);


    }

    //反注册
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    public  class  jiexi extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //加载图片的简单方法
            Glide.with(context).load(path).into(imageView);
        }
    }


}
