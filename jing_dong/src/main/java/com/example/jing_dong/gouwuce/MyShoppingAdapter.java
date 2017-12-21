package com.example.jing_dong.gouwuce;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jing_dong.R;
import com.example.jing_dong.gouwuce_bean.ShoppingBean;

import java.util.List;

/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class MyShoppingAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ShoppingBean shoppingBean;
    OnAllCheckedBoxNeedChangeListener onAllCheckedBoxNeedChangeListener;
    OnGoodsCheckedChangeListener onGoodsCheckedChangeListener;
    private int totalCount;
    private double totalPrice;

    public interface OnGoodsCheckedChangeListener {
        void onGoodsCheckedChange(int totalCount, double totalPrice);
    }

    public void setOnGoodsCheckedChangeListener(OnGoodsCheckedChangeListener onGoodsCheckedChangeListener) {
        this.onGoodsCheckedChangeListener = onGoodsCheckedChangeListener;
    }

    public void setOnAllCheckedBoxNeedChangeListener(OnAllCheckedBoxNeedChangeListener onAllCheckedBoxNeedChangeListener) {
        this.onAllCheckedBoxNeedChangeListener = onAllCheckedBoxNeedChangeListener;
    }

    public interface OnAllCheckedBoxNeedChangeListener {
        void onCheckedBoxNeedChange(boolean allParentIsChecked);
    }

    public MyShoppingAdapter(Context context, ShoppingBean shoppingBean) {
        this.context = context;
        this.shoppingBean = shoppingBean;
    }

    @Override
    public int getGroupCount() {


            int size = shoppingBean.getData().size();

            return size;


    }

    @Override
    public int getChildrenCount(int i) {
        int size = shoppingBean.getData().get(i).getList().size();
        return size;
    }

    @Override
    public Object getGroup(int i) {
        ShoppingBean.DataBean dataBean = shoppingBean.getData().get(i);
        return dataBean;
    }

    @Override
    public Object getChild(int i, int i1) {
        ShoppingBean.DataBean.ListBean listBean = shoppingBean.getData().get(i).getList().get(i1);
        return listBean;
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
        return true;
    }

    @Override
    public View getGroupView(final int i, boolean b, View view, ViewGroup viewGroup) {
        GroupViewHolder groupViewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.shopping_parent, null);
            groupViewHolder = new GroupViewHolder();
//            view = View.inflate(context, R.layout.shopping_parent, null);
            groupViewHolder.tv_title_parent = (TextView) view.findViewById(R.id.tv_title_parent);
            groupViewHolder.id_tv_edit = (TextView) view.findViewById(R.id.id_tv_edit);
            groupViewHolder.id_cb_select_parent = (CheckBox) view.findViewById(R.id.id_cb_select_parent);
            view.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) view.getTag();
        }
        ShoppingBean.DataBean dataBean = shoppingBean.getData().get(i);
        String sellerName = dataBean.getSellerName();
        groupViewHolder.tv_title_parent.setText(sellerName);
        final boolean checked = dataBean.isChecked();
        groupViewHolder.id_cb_select_parent.setChecked(checked);
        groupViewHolder.id_cb_select_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupOneParentAllChildChecked(!checked, i);
                onAllCheckedBoxNeedChangeListener.onCheckedBoxNeedChange(dealAllParentIsChecked());

            }
        });


        return view;
    }

    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildViewHolder childViewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.shopping_child, null);
            childViewHolder = new ChildViewHolder();
            childViewHolder.id_tv_count = (TextView) view.findViewById(R.id.textView15);
            childViewHolder.id_iv_logo = (ImageView) view.findViewById(R.id.imageView6);
            childViewHolder.tv_items_child = (TextView) view.findViewById(R.id.textView13);
            childViewHolder.id_tv_discount_price = (TextView) view.findViewById(R.id.textView14);
            childViewHolder.id_cb_select_child = (CheckBox) view.findViewById(R.id.checkBox);
            childViewHolder.id_iv_add = (ImageView) view.findViewById(R.id.id_iv_add);
            childViewHolder.id_iv_reduce = (ImageView) view.findViewById(R.id.id_iv_reduce);
            view.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) view.getTag();
        }
        final ShoppingBean.DataBean.ListBean listBean = shoppingBean.getData().get(i).getList().get(i1);
        childViewHolder.tv_items_child.setText(listBean.getTitle());
        childViewHolder.id_tv_discount_price.setText(listBean.getBargainPrice() + " ");
        final int num = listBean.getNum();
        childViewHolder.id_tv_count.setText(num + " ");
        childViewHolder.id_iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dealAdd(num, i, i1);

            }
        });
        childViewHolder.id_iv_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dealReduce(num, i, i1);
            }
        });
        final boolean checked = listBean.isChecked();
        childViewHolder.id_cb_select_child.setChecked(checked);
        String images = listBean.getImages();
        String[] split = images.split("\\|");
        Uri parse = Uri.parse(split[0]);
        childViewHolder.id_iv_logo.setImageURI(parse);
        childViewHolder.id_cb_select_child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listBean.setChecked(!checked);
                boolean b1 = dealOneParentAllChildIsChecked(i);
                shoppingBean.getData().get(i).setChecked(b1);
                onAllCheckedBoxNeedChangeListener.onCheckedBoxNeedChange(dealAllParentIsChecked());
                dealPrice();
                notifyDataSetChanged();


            }
        });


        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    public void dealAdd(int coun, int i, int i1) {
        coun++;
//        goodsBean.setCount(count);
        //  textView.setText(String.valueOf(count));
        shoppingBean.getData().get(i).getList().get(i1).setNum(coun);
        notifyDataSetChanged();
        dealPrice();
    }

    public void dealReduce(int coun, int i, int i1) {
//        int count = goodsBean.getCount();
        if (coun == 1) {
            return;
        }
        coun--;
        shoppingBean.getData().get(i).getList().get(i1).setNum(coun);
//        goodsBean.setCount(count);
        // textView.setText(String.valueOf(count));
        notifyDataSetChanged();
        dealPrice();
    }

    public boolean dealOneParentAllChildIsChecked(int groupPosition) {
        // StoreBean storeBean= (StoreBean) parentMapList.get(groupPosition).get("parentName");
        ShoppingBean.DataBean dataBean = shoppingBean.getData().get(groupPosition);
        List<ShoppingBean.DataBean.ListBean> list = dataBean.getList();
        for (int j = 0; j < list.size(); j++) {
            ShoppingBean.DataBean.ListBean listBean = list.get(j);
            if (!listBean.isChecked()) {
                return false;//如果有一个没选择  就false
            }
        }
        return true;
    }

    public boolean dealAllParentIsChecked() {

        for (int i = 0; i < shoppingBean.getData().size(); i++) {
            boolean checked = shoppingBean.getData().get(i).isChecked();
            if (!checked) {
                return false;//如果有一个没选择  就false
            }
        }
        return true;
    }

    public void setupAllChecked(boolean isChecked) {
        List<ShoppingBean.DataBean> data = shoppingBean.getData();

        for (int i = 0; i < data.size(); i++) {
            data.get(i).setChecked(isChecked);
            List<ShoppingBean.DataBean.ListBean> list = data.get(i).getList();
            for (int j = 0;     j < list.size(); j++) {
                ShoppingBean.DataBean.ListBean listBean = list.get(j);
                listBean.setChecked(isChecked);
            }
        }
        notifyDataSetChanged();
        dealPrice();
    }

    private void setupOneParentAllChildChecked(boolean isChecked, int groupPosition) {
        ShoppingBean.DataBean dataBean = shoppingBean.getData().get(groupPosition);
        dataBean.setChecked(isChecked);
        List<ShoppingBean.DataBean.ListBean> list = dataBean.getList();
        for (int j = 0; j < list.size(); j++) {
            ShoppingBean.DataBean.ListBean listBean = list.get(j);
            listBean.setChecked(isChecked);
        }
        notifyDataSetChanged();
         dealPrice();
    }

    public void dealPrice() {
        // showList();
        totalCount = 0;
        totalPrice = 0.00;
        List<ShoppingBean.DataBean> data = shoppingBean.getData();
        for (int i = 0; i < data.size(); i++) {
            //StoreBean storeBean= (StoreBean) parentMapList.get(i).get("parentName");

            List<ShoppingBean.DataBean.ListBean> list = data.get(i).getList();
            for (int j = 0; j < list.size(); j++) {
                ShoppingBean.DataBean.ListBean listBean = list.get(j);
                double bargainPrice = listBean.getBargainPrice();
                int num = listBean.getNum();
                boolean checked = listBean.isChecked();
                if (checked) {
                    totalCount++;//单品多数量只记1
                    totalPrice += bargainPrice * num;
                }

            }
        }
        //计算回调
        onGoodsCheckedChangeListener.onGoodsCheckedChange(totalCount, totalPrice);
    }

    class GroupViewHolder {
        TextView tv_title_parent;
        TextView id_tv_edit;
        CheckBox id_cb_select_parent;
    }

    class ChildViewHolder {
        CheckBox id_cb_select_child;
        TextView tv_items_child;
        TextView id_tv_discount_price;
        TextView id_tv_count;
        ImageView id_iv_logo;
        ImageView id_iv_reduce;
        ImageView id_iv_add;
    }
}
