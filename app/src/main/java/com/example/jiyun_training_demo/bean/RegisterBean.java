package com.example.jiyun_training_demo.bean;

public class RegisterBean {

    /**
     * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoxNywiaWF0IjoxNTgzNDAwODgyfQ.vTvY5DK7FcvvuIRXw3u8Nj7s-QD9uOdtND-pWNjTURI
     * userInfo : {"id":17,"username":"bde79a4c-5a83-4f6b-931b-78cd60647188","nickname":"zzz","gender":0,"avatar":"","birthday":0}
     */

    private String token;
    private UserInfoBean userInfo;

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
         * id : 17
         * username : bde79a4c-5a83-4f6b-931b-78cd60647188
         * nickname : zzz
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
