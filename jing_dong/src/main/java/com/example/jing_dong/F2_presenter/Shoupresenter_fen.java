package com.example.jing_dong.F2_presenter;

import com.example.jing_dong.Api_fenlei.Bean_fen;
import com.example.jing_dong.F2_modl.Shomodle_fen;
import com.example.jing_dong.F2_view.Iview_fen;

/**
 * Created by Administrator on 2017/12/18.
 */

public class Shoupresenter_fen implements Ipresenter_fen{
    Iview_fen iview_fen;
    private final Shomodle_fen shomodle_fen;

    public Shoupresenter_fen(Iview_fen iview_fen) {
        this.iview_fen = iview_fen;
        shomodle_fen = new Shomodle_fen();
    }

    @Override
    public void getmythis_fen(String pscid) {
        shomodle_fen.getmyImodle_fen(this,pscid);
    }

    @Override
    public void getmyIpresenter_fen(Bean_fen bean_fen) {
            iview_fen.getiview_fen(bean_fen);
    }
}
