package com.example.jing_dong.F2_presenter;

import com.example.jing_dong.Api_fenlei.Bean_xiangqing;
import com.example.jing_dong.F2_modl.Shoumodl_xiangqing;
import com.example.jing_dong.F2_view.Iview_xianqing;

/**
 * Created by Administrator on 2017/12/18.
 */

public class Shoupresenter_xiangqing implements Ipresenter_xiangqing{
    Iview_xianqing iview_xianqing;
    private final Shoumodl_xiangqing shoumodl_xiangqing;

    public Shoupresenter_xiangqing(Iview_xianqing iview_xianqing) {
        this.iview_xianqing = iview_xianqing;
        shoumodl_xiangqing = new Shoumodl_xiangqing();
    }

    @Override
    public void getmythis(String pid) {
        shoumodl_xiangqing.getmyimodel(this,pid);
    }

    @Override
    public void getmyipresenter(Bean_xiangqing bean_xiangqing) {
        iview_xianqing.getmyiview_xiangqing(bean_xiangqing);
    }
}
