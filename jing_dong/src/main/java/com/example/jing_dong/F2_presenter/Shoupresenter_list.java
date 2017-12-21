package com.example.jing_dong.F2_presenter;


import com.example.jing_dong.Api_fenlei.Bean_list;
import com.example.jing_dong.F2_modl.Shoumold_list;
import com.example.jing_dong.F2_view.Iview_list;

/**
 * Created by Administrator on 2017/12/12.
 */

public class Shoupresenter_list implements Ipresenter_list{
    Iview_list iview_list;
    private final Shoumold_list shoumold_list;

    public Shoupresenter_list(Iview_list iview_list) {
        this.iview_list = iview_list;
        shoumold_list = new Shoumold_list();
    }

    @Override
    public void getmythis_list() {
        shoumold_list.getmymodl_list(this);
    }

    @Override
    public void getmypresenter_list(Bean_list bean_list) {
            iview_list.getmylist_iview(bean_list);
    }
}
