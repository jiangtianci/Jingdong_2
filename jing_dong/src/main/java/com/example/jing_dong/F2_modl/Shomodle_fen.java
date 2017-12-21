package com.example.jing_dong.F2_modl;

import android.util.Log;

import com.example.jing_dong.Api_fenlei.API_class;
import com.example.jing_dong.Api_fenlei.Api_interface;
import com.example.jing_dong.Api_fenlei.Bean_fen;
import com.example.jing_dong.F2_presenter.Ipresenter_fen;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/18.
 */

public class Shomodle_fen implements Imodl_fen{
    @Override
    public void getmyImodle_fen(final Ipresenter_fen ipresenter_fen, String pscid) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_class.Fen_qian)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        Observable<Bean_fen> fen = retrofit.create(Api_interface.class).getmyapi_fen(pscid);

        fen.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean_fen>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("ccccccccccccc++++++",e.toString());
                    }

                    @Override
                    public void onNext(Bean_fen bean_fen) {

                        ipresenter_fen.getmyIpresenter_fen(bean_fen);
                        List<Bean_fen.DataBean> list = bean_fen.getData();

                        for (int i = 0; i <list.size() ; i++) {
                            String title = list.get(i).getTitle();
                            Log.i("ccccccccccccc++++++",title);
                        }

                    }
                });


    }
}
