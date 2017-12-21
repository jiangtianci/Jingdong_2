package com.example.jing_dong.fr;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.jing_dong.F1_modl.Bean_ok;
import com.example.jing_dong.F1_presenter.Shouokpresenter;
import com.example.jing_dong.F1_view.OkIview;
import com.example.jing_dong.R;
import com.example.jing_dong.Sousuo;
import com.example.jing_dong.adaper.Shou_xia_adaper;
import com.example.jing_dong.adaper.Shou_zhong_adaper;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */

public class Fragment1 extends Fragment implements OkIview{

    private String[] tuwang={
            "http://120.27.23.105/images/ad/1.jpg",
            "http://120.27.23.105/images/ad/2.jpg",
            "http://120.27.23.105/images/ad/0.jpg",
            "http://120.27.23.105/images/ad/3.jpg",};
    private static final int tapy_1=0;
    private static final int tapy_2=1;
    private static final int tapy_3=2;
    private View view;
    int a = 0;
    private RecyclerView rv;
    private List<String> list_tu;
    private MyRecycleradaper.MyviewHolder3 holder3;
    private EditText ed;
    private List<Bean_ok.DataBean> list;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view==null) {
            view = View.inflate(getContext(), R.layout.f1, null);
            //控件
            initKongjian();
            //Banner轮播图
            initbanner();
            //Recyclerview方法
            initrecycler();
            //关联presenter
            Shouokpresenter shouokpresenter = new Shouokpresenter(this);
            shouokpresenter.setview();
            ed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), Sousuo.class);
                    startActivity(intent);
                }
            });
        }
        return view;

    }

    //Banner方法
    private void initbanner() {
        list_tu = new ArrayList<>();
        for (String str: tuwang)
        {
            list_tu.add(str);
            a++;
        }
        //解析图片方法
//        ban.setImageLoader(new jiexi());
//        ban.setImages(list_tu);
//        ban.start();
    }


    //控件
    private void initKongjian() {
       // ban = view.findViewById(R.id.ban);
        rv = view.findViewById(R.id.rv);
        ed = view.findViewById(R.id.editText);

    }

    //Recyclerview方法
    private void initrecycler() {
        MyRecycleradaper adaper = new MyRecycleradaper();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(manager);
        rv.setAdapter(adaper);

    }
    //Ok方法
    @Override
    public void getokiview(Bean_ok bean_ok) {
        list = bean_ok.getData();
        Shou_xia_adaper adaper = new Shou_xia_adaper(getContext(), this.list);
        GridLayoutManager manager = new GridLayoutManager(getContext(),2);
        holder3.rv_shouxia.setLayoutManager(manager);
        holder3.rv_shouxia.setAdapter(adaper);

    }





    //Recyclerview适配器
    class MyRecycleradaper extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //banner轮播图
            if (viewType == tapy_1){
                View view = View.inflate(getContext(),R.layout.f1_shou_1,null);
                MyviewHolder1 holder1 = new MyviewHolder1(view);
                return holder1;
            }else if (viewType == tapy_2){
                View view = View.inflate(getContext(),R.layout.f1_shou_2,null);
                MyviewHolder2 holder2 = new MyviewHolder2(view);
                return holder2;
            }else if (viewType == tapy_3){
                View view = View.inflate(getContext(),R.layout.f1_shou_3,null);
                MyviewHolder3 holder3 = new MyviewHolder3(view);
                return holder3;
            }
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                 //Banner方法
                if (holder instanceof MyviewHolder1){
                        MyviewHolder1 holder1 = (MyviewHolder1) holder;
                        ((MyviewHolder1) holder).banner.setImageLoader(new jiexi()).setImages(list_tu).start();
                }
                if (holder instanceof MyviewHolder2){
                    MyviewHolder2 holder2 = (MyviewHolder2) holder;
                    Shou_zhong_adaper adaper = new Shou_zhong_adaper(getContext());
                    GridLayoutManager manager = new GridLayoutManager(getContext(),8);
                    holder2.rv_shouzhong.setLayoutManager(manager);
                    //holder2.rv_shouzhong.setAdapter(adaper);
                }
                if (holder instanceof MyviewHolder3){
                    holder3 = (MyviewHolder3) holder;

                }
        }

        @Override
        public int getItemCount() {
            return 3;
        }
        @Override
        public int getItemViewType(int position) {

            if (position == 0) {
                return tapy_1;
            } else if (position == 1) {
                return tapy_2;
            } else if (position == 2) {
                return tapy_3;
            }
            return tapy_1;
        }

        class MyviewHolder1 extends RecyclerView.ViewHolder{

            private final Banner banner;

            public MyviewHolder1(View itemView) {
                super(itemView);
                banner = itemView.findViewById(R.id.ban);
            }
        }

        class MyviewHolder2 extends RecyclerView.ViewHolder{

            private final RecyclerView rv_shouzhong;

            public MyviewHolder2(View itemView) {
                super(itemView);
                rv_shouzhong = itemView.findViewById(R.id.rv_shouzhong);
            }
        }

        class MyviewHolder3 extends RecyclerView.ViewHolder{

            private final RecyclerView rv_shouxia;

            public MyviewHolder3(View itemView) {
                super(itemView);
                rv_shouxia = itemView.findViewById(R.id.rv_shouxia);
            }
        }


    }

    //Banner解析图片方法
    private class jiexi extends com.youth.banner.loader.ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }


}
