package com.example.jing_dong.fr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jing_dong.Api_fenlei.Bean_chuan;
import com.example.jing_dong.Api_fenlei.Bean_list;
import com.example.jing_dong.F2_presenter.Shoupresenter_list;
import com.example.jing_dong.F2_view.Iview_list;
import com.example.jing_dong.R;
import com.example.jing_dong.adaper.Lsit_adaper;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */
public class Fragment2 extends Fragment implements Iview_list {

    private ListView lv;
    private Lsit_adaper adaper;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view==null) {
            view = View.inflate(getContext(), R.layout.f2, null);

            lv = view.findViewById(R.id.lv_er);

            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();


            Fragment2_ex fragment2_ex = new Fragment2_ex();
            beginTransaction.replace(R.id.f2_ex, fragment2_ex);

            beginTransaction.commit();

            Shoupresenter_list shoupresenter_list = new Shoupresenter_list(this);
            shoupresenter_list.getmythis_list();

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    //将int类型转换成String类型
                    String id = String.valueOf(i + 1);
                    EventBus.getDefault().postSticky(new Bean_chuan(id));

                    FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();


                    Fragment2_ex fragment2_ex = new Fragment2_ex();
                    beginTransaction.replace(R.id.f2_ex, fragment2_ex);

                    beginTransaction.commit();
                    //变色
                    adaper.setSelectedPosition(i);
                    adaper.notifyDataSetInvalidated();

                }


            });


        }
        return view;
    }


    @Override
    public void getmylist_iview(Bean_list bean_list) {
        List<Bean_list.DataBean> list_lv = bean_list.getData();

        adaper = new Lsit_adaper(list_lv,getContext());

        lv.setAdapter(adaper);
    }
}
