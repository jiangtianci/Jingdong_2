package com.example.jing_dong.fr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.jing_dong.Api_fenlei.Bean_chuan;
import com.example.jing_dong.Api_fenlei.Bean_ex;
import com.example.jing_dong.F2_presenter.Shouprsenter_ex;
import com.example.jing_dong.F2_view.Iview_ex;
import com.example.jing_dong.R;
import com.example.jing_dong.adaper.Ex_adaper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by Administrator on 2017/12/12.
 */

public class Fragment2_ex extends Fragment implements Iview_ex {

    private ExpandableListView ex;
    private String id;
        int diyi = 1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.f2_ex,null);
        String s = String.valueOf(diyi);
        ex = view.findViewById(R.id.ex);

        EventBus.getDefault().register(this);


        Shouprsenter_ex shouprsenter_ex = new Shouprsenter_ex(this);
        shouprsenter_ex.getmythis_ex(id);

        return view;
    }


    @Override
    public void getiview_ex(final Bean_ex bean_ex) {
        String name = bean_ex.getData().get(0).getName();

        List<Bean_ex.DataBean> list_ex = bean_ex.getData();
        Ex_adaper ex_adaper = new Ex_adaper(getContext(),bean_ex);
        ex.setAdapter(ex_adaper);
        //自动展开
        for (int i = 0; i <list_ex.size() ; i++) {
            ex.expandGroup(i);
        }

    }




    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public  void  getbean(Bean_chuan bean){
        id = bean.getId();


    }

    //反注册
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


}
