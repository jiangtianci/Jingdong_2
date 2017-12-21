package com.example.jing_dong.Api_fenlei;



import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/12/12.
 */

public interface Api_interface {

    @GET("product/getCatagory")
    Observable<Bean_list> getmyapi_hou_list();


    @GET("product/getProductCatagory")

    Observable<Bean_ex> getmyapi_hou_Ex(@Query("cid") String cid);


    @GET("product/getProducts")
    Observable<Bean_fen> getmyapi_fen(@Query("pscid") String pscid);

    @GET("product/getProductDetail")
    Observable<Bean_xiangqing> getmyapi_fen_xiangqing(@Query("pid") String pid);

}
