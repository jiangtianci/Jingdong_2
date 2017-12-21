package com.example.jing_dong.fr;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jing_dong.R;
import com.example.jing_dong.activity_denglu.Chuan_bean;
import com.example.jing_dong.activity_denglu.F5_login;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2017/11/6.
 */

public class Fragment5 extends Fragment{

    private Intent intent;
    private TextView tv_login;
    boolean feikong  = true;
    private String name;
    private ImageView im_touxiang;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view==null) {
            view = View.inflate(getContext(), R.layout.f5, null);

            im_touxiang = view.findViewById(R.id.my_touxiang);
            tv_login = view.findViewById(R.id.tv_my_login);
            tv_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view1) {
                    intent = new Intent(getContext(), F5_login.class);
                    startActivity(intent);
                }
            });
            EventBus.getDefault().register(this);

        }
            return view;
    }
    //接受传值
    @Subscribe(sticky =  true,threadMode = ThreadMode.MAIN)
    public void getbean(Chuan_bean bean) {
        name = bean.getName();
        if (!name.equals("000")) {
            tv_login.setText(bean.getName());
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.touxiang);
            RoundedBitmapDrawable circleDrawable = RoundedBitmapDrawableFactory.create(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.touxiang));
            circleDrawable.getPaint().setAntiAlias(true);
            circleDrawable.setCornerRadius(Math.max(bitmap.getWidth(), bitmap.getHeight()));

            im_touxiang.setImageDrawable(circleDrawable);
        } else {
            im_touxiang.setImageResource(R.drawable.ic_normal_code);
            tv_login.setText("点击登录");
        }
    }

    //反注册
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


}
