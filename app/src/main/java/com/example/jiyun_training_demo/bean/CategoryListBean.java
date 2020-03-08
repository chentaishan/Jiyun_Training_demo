package com.example.jiyun_training_demo.bean;

import java.util.List;

public class CategoryListBean {

    private int id;
    private String name;
    private List<GoodsListBean> goodsList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GoodsListBean> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsListBean> goodsList) {
        this.goodsList = goodsList;
    }

    public static class GoodsListBean {
        /**
         * id : 1009024
         * name : 日式和风懒人沙发
         * list_pic_url : http://yanxuan.nosdn.127.net/149dfa87a7324e184c5526ead81de9ad.png
         * retail_price : 599
         */

        private int id;
        private String name;
        private String list_pic_url;
        private float retail_price;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getList_pic_url() {
            return list_pic_url;
        }

        public void setList_pic_url(String list_pic_url) {
            this.list_pic_url = list_pic_url;
        }

        public float getRetail_price() {
            return retail_price;
        }

        public void setRetail_price(float retail_price) {
            this.retail_price = retail_price;
        }
    }
}
