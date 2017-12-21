package com.example.jing_dong.F2_modl;

import com.example.jing_dong.Api_fenlei.API_class;
import com.example.jing_dong.Api_fenlei.Api_interface;
import com.example.jing_dong.Api_fenlei.Bean_xiangqing;
import com.example.jing_dong.F2_presenter.Ipresenter_xiangqing;

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

public class Shoumodl_xiangqing implements Imodl_xiangqing{
    @Override
    public void getmyimodel(final Ipresenter_xiangqing xiangqing, String pid) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_class.Fen_xiangqing)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Observable<Bean_xiangqing> observable = retrofit.create(Api_interface.class).getmyapi_fen_xiangqing(pid);

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean_xiangqing>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Bean_xiangqing bean_xiangqing) {

                        xiangqing.getmyipresenter(bean_xiangqing);



                    }
                });



    }
}
