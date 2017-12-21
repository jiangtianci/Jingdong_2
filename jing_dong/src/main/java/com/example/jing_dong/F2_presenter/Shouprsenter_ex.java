package com.example.jing_dong.F2_presenter;


import com.example.jing_dong.Api_fenlei.Bean_ex;
import com.example.jing_dong.F2_modl.Shoumold_ex;
import com.example.jing_dong.F2_view.Iview_ex;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Shouprsenter_ex implements Ipresenter_ex{

    Iview_ex iview_ex;
    private final Shoumold_ex shoumold_ex;

    public Shouprsenter_ex(Iview_ex iview_ex) {
        this.iview_ex = iview_ex;
        shoumold_ex = new Shoumold_ex();
    }

    @Override
    public void getmythis_ex(String cid) {
        shoumold_ex.getmymodl_list(this,cid);
    }

    @Override
    public void getmypresenter_ex(Bean_ex bean_ex) {
            iview_ex.getiview_ex(bean_ex);
    }
}
