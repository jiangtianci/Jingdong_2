package com.example.jing_dong.adaper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jing_dong.R;
import com.example.jing_dong.F1_modl.Bean_ok;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2017/11/7.
 */

public class Shou_xia_adaper extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    List<Bean_ok.DataBean> list;
    //点击事件
    private OnItemClickListener onItemClickListener;
    private Myviewholder holde1;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }



    public Shou_xia_adaper(Context context, List<Bean_ok.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.f1_shou_1xia,null);
        Myviewholder holder = new Myviewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //分割图片接口
        String[] split = list.get(position).getImages().split("\\|");

        holde1 = (Myviewholder) holder;
        holde1.tv.setText(list.get(position).getTitle());
        //打印图片
        for (String str: split) {
            Picasso.with(context).load(str).into(holde1.im);
        }
        //点击事件
        if(onItemClickListener!=null){
            ((Myviewholder) holder).ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(holde1.itemView,position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Myviewholder extends RecyclerView.ViewHolder{

        private final ImageView im;
        private final TextView tv;
        private final LinearLayout ll;

        public Myviewholder(View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.im_shou_xia);
            tv = itemView.findViewById(R.id.tv_shou_xia);
            ll = itemView.findViewById(R.id.ll);
        }
    }

}
