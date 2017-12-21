package com.example.jing_dong.activity_denglu.modl;

import android.telecom.Call;

import com.example.jing_dong.activity_denglu.presenter.Zpresenter;

import java.io.IOException;


/**
 * Created by Administrator on 2017/11/16.
 */

public class Zmodl implements Zimodl{
    String mobile;
    String password;

    public Zmodl(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }
    @Override
    public void getZimodl(final Zpresenter zpresenter) {
        OkHttpClient client = new OkHttpClient();
        FormBody body = new FormBody.Builder()
                .add("mobile", mobile)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url("http://120.27.23.105/user/reg")
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
                ZBean zBean = gson.fromJson(string, ZBean.class);
                zpresenter.getzpresenter(zBean);

            }
        });


    }
}
