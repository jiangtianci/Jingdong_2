package com.example.jing_dong.F1_presenter;

import com.example.jing_dong.F1_modl.Bean_ok;
import com.example.jing_dong.F1_modl.Shouokmodl;
import com.example.jing_dong.F1_view.OkIview;

/**
 * Created by Administrator on 2017/11/7.
 */

public class Shouokpresenter implements Iokpresenter{
    OkIview okIview;
    private final Shouokmodl shouokmodl;

    public Shouokpresenter(OkIview okIview) {
        this.okIview = okIview;
        shouokmodl = new Shouokmodl();
    }

    @Override
    public void setview() {
        shouokmodl.getiokmobl(this);
    }

    @Override
    public void getokpresenter(Bean_ok bean_ok) {
            okIview.getokiview(bean_ok);
    }
}
