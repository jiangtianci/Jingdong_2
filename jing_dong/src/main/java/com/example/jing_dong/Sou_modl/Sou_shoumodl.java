package com.example.jing_dong.Sou_modl;

import android.util.Log;

import com.example.jing_dong.Sou_presenter.Sou_Ipresenter;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2017/11/10.
 */

public class Sou_shoumodl implements Sou_modl{
    @Override
    public void Shou_modl(final Sou_Ipresenter sou_ipresenter, String name) {
        //String url="http://120.27.23.105/product/searchProducts?keywords="+name+"&page=1&source=android";
        String url="http://120.27.23.105/product/searchProducts?keywords="+name+"&page=1&source=android";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Gson gson = new Gson();
                Log.i("xxx",responseString);
               Sou_Bean sou_bean = gson.fromJson(responseString, Sou_Bean.class);

                sou_ipresenter.sou_p_presenter(sou_bean);


            }
        });

    }
}
