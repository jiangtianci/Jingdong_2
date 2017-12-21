package com.example.jing_dong.F2_modl;

import android.util.Log;

import com.example.jing_dong.Api_fenlei.API_class;
import com.example.jing_dong.Api_fenlei.Api_interface;
import com.example.jing_dong.Api_fenlei.Bean_ex;
import com.example.jing_dong.F2_presenter.Ipresenter_ex;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/12.
 */

public class Shoumold_ex implements Imod_ex{
    @Override
    public void getmymodl_list(final Ipresenter_ex ipresenter_ex, final String cid) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_class.Ex_qian)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        Observable<Bean_ex> observable = retrofit.create(Api_interface.class).getmyapi_hou_Ex(cid);

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean_ex>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("eeeeeeeeeeeeeeee失败",e.toString());
                    }

                    @Override
                    public void onNext(Bean_ex bean_ex) {
                        Log.i("eeeeeeeeeeeeeeee",bean_ex.getData().get(1).getName());


                        ipresenter_ex.getmypresenter_ex(bean_ex);
                    }
                });

    }
}
