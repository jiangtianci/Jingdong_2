package com.example.jing_dong.gouwuce;

import com.example.jing_dong.gouwuce_bean.ClassleftBean;
import com.example.jing_dong.gouwuce_bean.GoodsListBean;
import com.example.jing_dong.gouwuce_bean.HomeBean;
import com.example.jing_dong.gouwuce_bean.IDetailsDataBean;
import com.example.jing_dong.gouwuce_bean.ResponseBean;
import com.example.jing_dong.gouwuce_bean.ShoppingBean;
import com.example.jing_dong.gouwuce_bean.UserBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/11/2 0002.
 */

public interface IRetrofitApi {
    @POST("user/login")
    Call<UserBean> getString(@Query("mobile") String mobile,
                             @Query("password") String password);

    @POST("user/reg")
    Call<ResponseBean> setreg(@Query("mobile") String mobile,
                              @Query("password") String password);

    @GET("product/getCatagory")
    Call<ClassleftBean> getClassLeft();

    @POST("product/getProducts")
    Call<GoodsListBean> getGoods(@Query("pscid") int pscid);

    @POST("product/getProductDetail")
    Call<IDetailsDataBean> getDetails(@Query("pid") int pid);

    @GET("ad/getAd")
    Call<HomeBean> getHomeData();

    @POST("product/addCart")
    Call<ResponseBean> addShopping(@Query("uid") int uid, @Query("pid") int pid, @Query("sellerid") int sellerid);

    @POST("product/getCarts")
    Call<ShoppingBean> showShopping(@Query("source") String source, @Query("uid") int uid);

    @POST("product/createOrder")
    Call<ResponseBean> showOrder(@Query("uid") int uid, @Query("price") double price);


}
