package com.example.jing_dong.fr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jing_dong.R;
import com.example.jing_dong.gouwuce.API;
import com.example.jing_dong.gouwuce.IRetrofitApi;
import com.example.jing_dong.gouwuce.MyShoppingAdapter;
import com.example.jing_dong.gouwuce.RetrofitUtils;
import com.example.jing_dong.gouwuce_bean.ShoppingBean;
import com.example.jing_dong.zhifu.PayDemoActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/11/6.
 */

public class Fragment4 extends Fragment implements View.OnClickListener {
    private View view;
    /**
     * 购物车
     */
    private TextView mIdTvCartTitle;
    /**
     * 编辑
     */
    private TextView mIdTvEditAll;
    /**
     * 全选
     */
    private CheckBox mIdCbSelectAll;
    private TextView mIdTvTotalPrice;
    private TextView mIdTvTotalCountJiesuan;
    private LinearLayout mIdLlNormalAllState;
    /**
     * 移到收藏夹
     */
    private TextView mIdTvSaveStarAll;
    /**
     * 删除
     */
    private TextView mIdTvDeleteAll;
    private LinearLayout mIdLlEditingAllState;
    private ExpandableListView mExpandedMenu;
    private MyShoppingAdapter myShoppingAdapter;
    private ShoppingBean body;
    private View view1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

                view1 = View.inflate(getContext(), R.layout.shopping, null);
                initView(view1);
                mExpandedMenu.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                        return true;
                    }
                });
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                boolean user = defaultSharedPreferences.getBoolean("user", true);
                //Log.v("tag", user + " ");
                if (user) {
                    int uid = defaultSharedPreferences.getInt("uid", 1496);
                    Log.v("tag", uid + " 用户ID ");
                    IRetrofitApi apiService = RetrofitUtils.getInstance().getApiService(API.CLASS, IRetrofitApi.class);
                    Call<ShoppingBean> shoppingBeanCall = apiService.showShopping("android",uid);
                    shoppingBeanCall.enqueue(new Callback<ShoppingBean>() {
                        @Override
                        public void onResponse(Call<ShoppingBean> call, Response<ShoppingBean> response) {
                            body = response.body();
                            if (body.getMsg().toString().equals("请求成功") && body.getMsg().toString() != null) {
                                myShoppingAdapter = new MyShoppingAdapter(getContext(), body);
                                mExpandedMenu.setAdapter(myShoppingAdapter);
                            } else {
                                Toast.makeText(getContext(), "请求失败", Toast.LENGTH_SHORT).show();
                            }

                            int groupCount = mExpandedMenu.getCount();
                            for (int i = 0; i < groupCount; i++) {
                                mExpandedMenu.expandGroup(i);
                            }
                            if (body.getMsg().toString().equals("请求成功") && body.getMsg().toString() != null) {
                                myShoppingAdapter.setOnAllCheckedBoxNeedChangeListener(new MyShoppingAdapter.OnAllCheckedBoxNeedChangeListener() {
                                    @Override
                                    public void onCheckedBoxNeedChange(boolean allParentIsChecked) {
                                        mIdCbSelectAll.setChecked(allParentIsChecked);
                                    }
                                });
                            }
                            if (body.getMsg().toString().equals("请求成功") && body.getMsg().toString() != null) {
                                myShoppingAdapter.setOnGoodsCheckedChangeListener(new MyShoppingAdapter.OnGoodsCheckedChangeListener() {
                                    @Override
                                    public void onGoodsCheckedChange(int totalCount, double totalPrice) {
                                        mIdTvTotalCountJiesuan.setText("结算" + "(" + totalCount + ")");
                                        mIdTvTotalPrice.setText("合计" + "(" + totalPrice + ")");
                                    }
                                });
                            }
                        }

                        @Override
                        public void onFailure(Call<ShoppingBean> call, Throwable t) {

                        }
                    });
                }

        return view1;
    }

    private void initView(View view) {
        mIdTvCartTitle = (TextView) view.findViewById(R.id.id_tv_cart_title);
        mIdTvEditAll = (TextView) view.findViewById(R.id.id_tv_edit_all);
        mIdCbSelectAll = (CheckBox) view.findViewById(R.id.id_cb_select_all);
        mIdTvTotalPrice = (TextView) view.findViewById(R.id.id_tv_totalPrice);
        mIdTvTotalCountJiesuan = (TextView) view.findViewById(R.id.id_tv_totalCount_jiesuan);
        mIdTvTotalCountJiesuan.setOnClickListener(this);
        mIdLlNormalAllState = (LinearLayout) view.findViewById(R.id.id_ll_normal_all_state);
        mIdTvSaveStarAll = (TextView) view.findViewById(R.id.id_tv_save_star_all);
        mIdTvDeleteAll = (TextView) view.findViewById(R.id.id_tv_delete_all);
        mIdLlEditingAllState = (LinearLayout) view.findViewById(R.id.id_ll_editing_all_state);
        mExpandedMenu = (ExpandableListView) view.findViewById(R.id.expanded_menu);
        mIdCbSelectAll.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_tv_totalCount_jiesuan:
                Intent intent = new Intent(getContext(), PayDemoActivity.class);
                intent.putExtra("price", body.getData().get(0).getList().get(0).getPrice());
                //Intent intent = new Intent(getContext(), Dizhi_class.class);
                getContext().startActivity(intent);
                break;
            case R.id.id_cb_select_all:
                boolean checked = mIdCbSelectAll.isChecked();
                Log.v("tag", checked + "全选 ");
                myShoppingAdapter.setupAllChecked(checked);
                break;

        }
    }
}
;