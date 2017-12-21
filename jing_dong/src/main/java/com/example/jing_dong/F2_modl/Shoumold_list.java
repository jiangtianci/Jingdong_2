package com.example.jing_dong.F2_modl;

import android.util.Log;

import com.example.jing_dong.Api_fenlei.API_class;
import com.example.jing_dong.Api_fenlei.Api_interface;
import com.example.jing_dong.Api_fenlei.Bean_list;
import com.example.jing_dong.F2_presenter.Ipresenter_list;

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

public class Shoumold_list implements Imod_list{
    @Override
    public void getmymodl_list(final Ipresenter_list ipresenter_list) {


        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_class.List_qian)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                //拦截器
                //.client(okHttpClient);
                .build();
        Api_interface api_interface = retrofit.create(Api_interface.class);

        Observable<Bean_list> ob = api_interface.getmyapi_hou_list();
        ob.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean_list>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("sssssssssssssss",e.toString());
                    }

                    @Override
                    public void onNext(Bean_list bean_list) {
                        Log.i("sssssssssssssss",bean_list.getData().get(0).getName());
                        ipresenter_list.getmypresenter_list(bean_list);
                    }
                });


    }
}
