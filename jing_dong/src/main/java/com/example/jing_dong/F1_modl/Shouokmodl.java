package com.example.jing_dong.F1_modl;

import android.util.Log;

import com.example.jing_dong.F1_presenter.Iokpresenter;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2017/11/7.
 */

public class Shouokmodl implements Iokmobl{
    //首页接口
    String url="http://120.27.23.105/product/searchProducts?keywords=%E6%89%8B%E6%9C%BA&page=1&source=android";
    @Override
    public void getiokmobl(final Iokpresenter iokpresenter) {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.i("ssss失败",responseString);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                               Gson gson = new Gson();
                Bean_ok bean_ok1 = gson.fromJson(responseString, Bean_ok.class);
                Log.i("qqqq",bean_ok1.getData().get(0).getTitle());
                iokpresenter.getokpresenter(bean_ok1);

            }
        });


    }
}
