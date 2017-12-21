package com.example.jing_dong.Dizhi_bean;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/12/15.
 */

public class Dizhi_bean_tjbean {

    /**
     * msg : 添加成功
     * code : 0
     */

    private String msg;
    private String code;

    public static Dizhi_bean_tjbean objectFromData(String str) {

        return new Gson().fromJson(str, Dizhi_bean_tjbean.class);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
