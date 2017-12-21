package com.example.jing_dong.activity_denglu.presenter;

import com.example.jing_dong.activity_denglu.modl.LoBean;
import com.example.jing_dong.activity_denglu.modl.LoShoumodl;
import com.example.jing_dong.activity_denglu.view.Loiview;

/**
 * Created by Administrator on 2017/11/16.
 */

public class Loshoupresenter implements Loipresenter{
    Loiview loiview;
    String mobile;
    String password;
    private final LoShoumodl loShoumodl;

    public Loshoupresenter(Loiview loiview, String mobile, String password) {
        this.loiview = loiview;
        this.mobile = mobile;
        this.password = password;

        loShoumodl = new LoShoumodl(mobile,password);

    }

    @Override
    public void getimodl() {
        loShoumodl.getloimodl(this);
    }

    @Override
    public void getipresenter(LoBean loBean) {
            loiview.getLoiview(loBean);
    }
}
