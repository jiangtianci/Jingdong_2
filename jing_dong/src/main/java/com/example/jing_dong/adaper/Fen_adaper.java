package com.example.jing_dong.adaper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jing_dong.Api_fenlei.Bean_fen;
import com.example.jing_dong.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 */

public class Fen_adaper extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    List<Bean_fen.DataBean> list;
    private Fen_hodler fen_hodler;
    private AbstractDraweeController build;

    public Fen_adaper(Context context, List<Bean_fen.DataBean> list) {
        this.context = context;
        this.list = list;
    }
    SetonClick setonClick;
    //接口回调方法
    public interface SetonClick{
        void setOnclick(int position);
    }
    //set方法
    public void setSetonClick(SetonClick setonClick) {
        this.setonClick = setonClick;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.fen_item,null);
        fen_hodler = new Fen_hodler(view);
        return fen_hodler;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        String[] split = list.get(position).getImages().split("\\|");

        for (String str: split) {
            build = Fresco.newDraweeControllerBuilder()
                    .setUri(str)
                    .setAutoPlayAnimations(true)
                    .build();
        }

        fen_hodler.sdv.setController(build);
        fen_hodler.fen_tv.setText(list.get(position).getTitle());
        fen_hodler.tv_tv.setText(list.get(position).getSubhead());


        //点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (setonClick != null){
                    setonClick.setOnclick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class  Fen_hodler extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv;
        private final TextView fen_tv;
        private final TextView tv_tv;

        public Fen_hodler(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.fen_sdv);
            fen_tv = itemView.findViewById(R.id.fen_tv);
            tv_tv = itemView.findViewById(R.id.fen_tv_tv);
        }
    }
}
