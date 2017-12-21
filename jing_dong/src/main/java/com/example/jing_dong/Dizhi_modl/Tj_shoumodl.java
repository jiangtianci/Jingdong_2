package com.example.jing_dong.Dizhi_modl;

import com.example.jing_dong.Dizhi_bean.Dizhi_bean_tjbean;
import com.example.jing_dong.Dizhi_presenter.Tj_ipresenter;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/12/15.
 */

public class Tj_shoumodl implements Tj_imodl{
    String uid;
    String addr;
    String mobile;
    String name;
    String token;
    public Tj_shoumodl(String uid, String addr, String mobile, String name,String token) {
        this.uid = uid;
        this.addr = addr;
        this.mobile = mobile;
        this.name = name;
        this.token = token;
    }

    @Override
    public void getmytj_imodl(final Tj_ipresenter tj_ipresenter) {
        OkHttpClient client = new OkHttpClient();
        FormBody body = new FormBody.Builder()
                .add("uid", uid)
                .add("addr", addr)
                .add("mobile", mobile)
                .add("name", name)
                .add("token",token)
                .build();

        Request request = new Request.Builder()
                //https://www.zhaoapi.cn/user/addAddr?uid=2320&addr=北京市昌平区金域国际1-1-1&mobile=18612991023&name=13161972159
                //.url("http://120.27.23.105/user/reg")
                .url("https://www.zhaoapi.cn/user/addAddr?uid=2320&addr=北京市昌平区金域国际1-1-1&mobile=18612991023&name=13161972159")
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                Dizhi_bean_tjbean json = gson.fromJson(string, Dizhi_bean_tjbean.class);
                tj_ipresenter.getmytj_presenter(json);

            }
        });





    }
}
