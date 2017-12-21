package com.example.jing_dong.gouwuce_bean;

/**
 * Created by Administrator on 2017/11/7 0007.
 */

public class UserBean {

    /**
     * msg : 登录成功
     * code : 0
     * data : {"age":null,"appkey":"7169b8153e004753","appsecret":"E82ABE7A7B51F9CF44AD30A5895986BA","createtime":"2017-11-07T08:35:33","email":null,"gender":null,"icon":null,"mobile":"18813073156","money":null,"nickname":null,"password":"CC9A08B0EB9F02AFDA07D24BF9DFB0F3","token":"8DDE1C6ACA55766DF920C419266A5211","uid":1639,"username":"18813073156"}
     */

    private String msg;
    private String code;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : 7169b8153e004753
         * appsecret : E82ABE7A7B51F9CF44AD30A5895986BA
         * createtime : 2017-11-07T08:35:33
         * email : null
         * gender : null
         * icon : null
         * mobile : 18813073156
         * money : null
         * nickname : null
         * password : CC9A08B0EB9F02AFDA07D24BF9DFB0F3
         * token : 8DDE1C6ACA55766DF920C419266A5211
         * uid : 1639
         * username : 18813073156
         */

        private Object age;
        private String appkey;
        private String appsecret;
        private String createtime;
        private Object email;
        private Object gender;
        private Object icon;
        private String mobile;
        private Object money;
        private Object nickname;
        private String password;
        private String token;
        private int uid;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public String getAppkey() {
            return appkey;
        }

        public void setAppkey(String appkey) {
            this.appkey = appkey;
        }

        public String getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(String appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getMoney() {
            return money;
        }

        public void setMoney(Object money) {
            this.money = money;
        }

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
