package com.example.jing_dong.Dizhi_API;

import com.example.jing_dong.Dizhi_bean.Dizhi_bean_tjbean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/12/15.
 */

public interface Dizhi_interface {
    //添加地址
    // https://www.zhaoapi.cn/user/addAddr?uid=71&addr=%E5%8C%97%E4%BA%AC%E5%B8%82%E6%98%8C%E5%B9%B3%E5%8C%BA%E9%87%91%E5%9F%9F%E5%9B%BD%E9%99%851-1-1&mobile=18612991023&name=kson
    @GET("user/addAddr?uid=71&addr=%E5%8C%97%E4%BA%AC%E5%B8%82%E6%98%8C%E5%B9%B3%E5%8C%BA%E9%87%91%E5%9F%9F%E5%9B%BD%E9%99%851-1-1&mobile=18612991023&name=kson")
        Observable<Dizhi_bean_tjbean> getmytianjia(@Query("uid") String uid,@Query("addr") String addr,@Query("mobile") String mobile,@Query("name") String name);



}
