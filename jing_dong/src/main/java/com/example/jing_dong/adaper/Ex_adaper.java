package com.example.jing_dong.adaper;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.jing_dong.Api_fenlei.Bean_chuan2;
import com.example.jing_dong.Api_fenlei.Bean_ex;
import com.example.jing_dong.R;
import com.example.jing_dong.fenlei.Fenlei_1;



/**
 * Created by Administrator on 2017/12/13.
 */

public class Ex_adaper extends BaseExpandableListAdapter{

    Context context;
    Bean_ex bean_ex;

    public Ex_adaper(Context context, Bean_ex bean_ex) {
        this.context = context;
        this.bean_ex = bean_ex;
    }
    @Override
    public int getGroupCount() {

        return  bean_ex.getData().size();
    }

    @Override
    public int getChildrenCount(int i) {

        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return  bean_ex.getData().get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return bean_ex.getData().get(i).getList().get(i);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        View view_fu = View.inflate(context, R.layout.ex_fu_item,null);
        TextView tv_fu = view_fu.findViewById(R.id.tv_fu);
        tv_fu.setText(bean_ex.getData().get(i).getName());
        return view_fu;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        View view_zi =  View.inflate(context,R.layout.ex_zi_item,null);
        RecyclerView rv = view_zi.findViewById(R.id.rv_ex_zi);
        final Ex_zi_adaper ex_zi_adaper = new Ex_zi_adaper(context,bean_ex,i,i1);
        GridLayoutManager manager = new GridLayoutManager(context,3);
        rv.setLayoutManager(manager);
        rv.setAdapter(ex_zi_adaper);
        //接口回调点击适配器控件
        ex_zi_adaper.setSetonClick(new Ex_zi_adaper.SetonClick() {
            @Override
            public void setOnclick(int position) {
                Intent intent = new Intent(context, Fenlei_1.class);
                context.startActivity(intent);
                int pscid = bean_ex.getData().get(position).getList().get(position).getPscid();
                String s = String.valueOf(pscid);
                EventBus.getDefault().postSticky(new Bean_chuan2(s));
            }
        });
        return view_zi;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
