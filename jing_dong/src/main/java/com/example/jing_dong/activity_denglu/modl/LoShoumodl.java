package com.example.jing_dong.activity_denglu.modl;

import android.telecom.Call;

import com.example.jing_dong.activity_denglu.presenter.Loipresenter;

import java.io.IOException;


/**
 * Created by Administrator on 2017/11/16.
 */

public class LoShoumodl implements Loimodl{
           String mobile;
           String password;

    public LoShoumodl(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    @Override
    public void getloimodl(final Loipresenter loipresenter) {
        OkHttpClient client = new OkHttpClient();
        FormBody body = new FormBody.Builder()
                .add("mobile", mobile)
                .add("password", password)
                .build();
        Request request = new Request.Builder()
                .url("http://120.27.23.105/user/login")
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
                LoBean loBean = gson.fromJson(string, LoBean.class);
                loipresenter.getipresenter(loBean);
            }
        });

    }
}
