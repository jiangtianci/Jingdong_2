package com.example.jing_dong.activity_denglu.presenter;

import com.example.jing_dong.activity_denglu.modl.ZBean;
import com.example.jing_dong.activity_denglu.modl.Zmodl;
import com.example.jing_dong.activity_denglu.view.Ziview;

/**
 * Created by Administrator on 2017/11/16.
 */

public class ZShoupresenter implements Zpresenter{
    Ziview ziview;
    String mobile;
    String password;
    private final Zmodl zmodl;

    public ZShoupresenter(Ziview ziview, String mobile, String password) {
        this.ziview = ziview;
        this.mobile = mobile;
        this.password = password;
        zmodl = new Zmodl(mobile,password);
    }

    @Override
    public void getiview() {
        zmodl.getZimodl(this);
    }

    @Override
    public void getzpresenter(ZBean zBean) {
        ziview.getziview(zBean);
    }
}
