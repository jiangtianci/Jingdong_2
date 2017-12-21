package com.example.jing_dong.adaper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jing_dong.R;
import com.example.jing_dong.Sou_modl.Sou_Bean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2017/11/15.
 */

public class Sou_adaper extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    List<Sou_Bean.DataBean> list;

    public Sou_adaper(Context context, List<Sou_Bean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    private MyviewHoid hoid1;

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.sou_adap,null);
        MyviewHoid hoid1 = new MyviewHoid(view);
        return hoid1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Sou_Bean.DataBean dataBean = list.get(position);
        hoid1 = (MyviewHoid) holder;
        hoid1.rv_tv1.setText(dataBean.getTitle());
        Log.i("kkkk",list.get(position).getTitle());
        //分割图片

        String[] split = list.get(position).getImages().split("\\|");
        for (String str :split) {
            Picasso.with(context).load(str).into(hoid1.rv_im1);
        }
        if(onItemClickListener!=null){
            ((MyviewHoid) holder).ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(hoid1.itemView,position);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyviewHoid  extends RecyclerView.ViewHolder{

        private final TextView rv_tv1;
        private final ImageView rv_im1;
        private final LinearLayout ll;

        public MyviewHoid(View itemView) {
            super(itemView);
            rv_tv1 =  itemView.findViewById(R.id.sou_rv_tv);
            rv_im1 =    itemView.findViewById(R.id.sou_rv_im);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}


