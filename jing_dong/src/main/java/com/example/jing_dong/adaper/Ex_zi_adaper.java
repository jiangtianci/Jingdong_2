package com.example.jing_dong.adaper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jing_dong.Api_fenlei.Bean_ex;
import com.example.jing_dong.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Ex_zi_adaper extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    Bean_ex bean_ex;
    int i,i1;
    //接口回调点击事件
    SetonClick setonClick;
    //接口回调方法
    public interface SetonClick{
        void setOnclick(int position);
    }
    //set方法
    public void setSetonClick(SetonClick setonClick) {
        this.setonClick = setonClick;
    }

    public Ex_zi_adaper(Context context, Bean_ex bean_ex, int i, int i1) {
        this.context = context;
        this.bean_ex = bean_ex;
        this.i = i;
        this.i1 = i1;
    }

    private Ex_myviewhodle myviewhodle;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.ex_zi_ad_tiem,null);
        myviewhodle = new Ex_myviewhodle(view);
        return myviewhodle;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Picasso.with(context).load(bean_ex.getData().get(i).getList().get(position).getIcon()).into(myviewhodle.im);
        myviewhodle.tv.setText(bean_ex.getData().get(i).getList().get(position).getName());
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
        return bean_ex.getData().get(i).getList().size();
    }
    class Ex_myviewhodle extends RecyclerView.ViewHolder{

        private final ImageView im;
        private final TextView tv;

        public Ex_myviewhodle(View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.ex_zi_im);
            tv = itemView.findViewById(R.id.ex_zi_tv);
        }
    }
}
