package com.example.jing_dong.Dizhi_presenter;

import com.example.jing_dong.Dizhi_bean.Dizhi_bean_tjbean;
import com.example.jing_dong.Dizhi_modl.Tj_shoumodl;
import com.example.jing_dong.Dizhi_view.Tj_iview;

/**
 * Created by Administrator on 2017/12/15.
 */

public class Tj_shoupresenter implements Tj_ipresenter{
    private final Tj_shoumodl tj_shoumodl;
    Tj_iview tj_iview;
    String uid;
    String addr;
    String mobile;
    String name;
    String token;

    public Tj_shoupresenter(Tj_iview tj_iview, String uid, String addr, String mobile, String name,String token) {
        this.tj_iview = tj_iview;
        this.uid = uid;
        this.addr = addr;
        this.mobile = mobile;
        this.name = name;
        this.token = token;
        tj_shoumodl = new Tj_shoumodl(uid,addr,mobile,name,token);

    }


    @Override
    public void getmytj_this() {
        tj_shoumodl.getmytj_imodl(this);
    }

    @Override
    public void getmytj_presenter(Dizhi_bean_tjbean tjbean) {
            tj_iview.getmytj_ivew(tjbean);
    }
}
