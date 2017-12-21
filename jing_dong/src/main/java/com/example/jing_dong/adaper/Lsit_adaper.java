package com.example.jing_dong.adaper;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jing_dong.Api_fenlei.Bean_list;
import com.example.jing_dong.R;

import java.util.List;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Lsit_adaper extends BaseAdapter{
    List<Bean_list.DataBean> list_lv;
    Context context;
    public Lsit_adaper(List<Bean_list.DataBean> list_lv, Context context) {
        this.list_lv = list_lv;
        this.context = context;
    }


    //变色
    private ViewHolder holder;
    private int selectedPosition = 0;
    public void setSelectedPosition(int position) {
        selectedPosition = position;
    }

    @Override
    public int getCount() {
        return list_lv.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view  = View.inflate(context, R.layout.list_item,null);
            holder = new ViewHolder();
            holder.tv_er = view.findViewById(R.id.tv_list);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        holder.tv_er.setText(list_lv.get(i).getName());
        //判断点击变色
        if (selectedPosition == i) {
            view.setBackgroundColor(Color.parseColor("#F5F6F8"));
            holder.tv_er.setTextColor(Color.parseColor("#FF2D49"));
        } else {
            view.setBackgroundColor(Color.TRANSPARENT);
            holder.tv_er.setTextColor(Color.parseColor("#393939"));
        }

        return view;

    }
    class ViewHolder{
        TextView tv_er;
    }

}

