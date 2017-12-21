package com.example.jing_dong.Sou_presenter;

import com.example.jing_dong.Sou_modl.Sou_Bean;
import com.example.jing_dong.Sou_modl.Sou_shoumodl;
import com.example.jing_dong.Sou_view.Sou_Iview;

/**
 * Created by Administrator on 2017/11/10.
 */

public class Sou_shoupresenter implements Sou_Ipresenter {
    Sou_Iview souIview;
    private final Sou_shoumodl shoushoumodl;

    public Sou_shoupresenter(Sou_Iview souIview) {
        this.souIview = souIview;
        shoushoumodl = new Sou_shoumodl();
    }

    @Override
    public void Sou_p_name(String name) {
        shoushoumodl.Shou_modl(this,name);
    }

    @Override
    public void sou_p_presenter(Sou_Bean sou_bean) {
            souIview.sou_iview(sou_bean);
    }
}
