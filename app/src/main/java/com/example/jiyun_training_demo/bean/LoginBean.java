package com.example.jiyun_training_demo.bean;

public class LoginBean {


    /**
     * code : 200
     * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo1LCJpYXQiOjE1ODMzOTc3ODl9.HuBbOlt7qj-SiLcJXhvEjHNrrqhun4JtxrBiZIu_bSg
     * userInfo : {"id":5,"username":"a878f5fa-9fd7-461a-82cc-1af52492e0d2","nickname":"qq1","gender":0,"avatar":"","birthday":0}
     */

    private int code;
    private String token;
    private UserInfoBean userInfo;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public static class UserInfoBean {
        /**
         * id : 5
         * username : a878f5fa-9fd7-461a-82cc-1af52492e0d2
         * nickname : qq1
         * gender : 0
         * avatar :
         * birthday : 0
         */

        private int id;
        private String username;
        private String nickname;
        private int gender;
        private String avatar;
        private int birthday;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getBirthday() {
            return birthday;
        }

        public void setBirthday(int birthday) {
            this.birthday = birthday;
        }
    }
}
