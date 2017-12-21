package com.example.jing_dong.adaper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.jing_dong.R;

/**
 * Created by Administrator on 2017/11/7.
 */

public class Shou_zhong_adaper extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;

    public Shou_zhong_adaper(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.f1_shou_1zhong,null);
        Myviewholder holder = new Myviewholder(view);




        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Myviewholder holde1 = (Myviewholder) holder;
        holde1.im.setImageResource(R.drawable.timg);

    }

    @Override
    public int getItemCount() {
        return 16;
    }

    class Myviewholder extends RecyclerView.ViewHolder{

        private final ImageView im;

        public Myviewholder(View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.im);
        }
    }

}
