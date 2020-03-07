package com.example.jiyun_training_demo.bean;

import java.util.List;

public class HomeBean {

    @Override
    public String toString() {
        return "HomeBean{" +
                "banner=" + banner.size() +
                ", channel=" + channel.size() +
                ", newGoodsList=" + newGoodsList.size() +
                ", hotGoodsList=" + hotGoodsList.size() +
                ", brandList=" + brandList.size() +
                ", topicList=" + topicList.size() +
                ", categoryList=" + categoryList.size() +
                '}';
    }

        private List<BannerBean> banner;
        private List<Home_ChannelBean> channel;
        private List<NewGoodsListBean> newGoodsList;
        private List<HotGoodsListBean> hotGoodsList;
        private List<Home_BrandListBean> brandList;
        private List<TopicListBean> topicList;
        private List<CategoryListBean> categoryList;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<Home_ChannelBean> getChannel() {
            return channel;
        }

        public void setChannel(List<Home_ChannelBean> channel) {
            this.channel = channel;
        }

        public List<NewGoodsListBean> getNewGoodsList() {
            return newGoodsList;
        }

        public void setNewGoodsList(List<NewGoodsListBean> newGoodsList) {
            this.newGoodsList = newGoodsList;
        }

        public List<HotGoodsListBean> getHotGoodsList() {
            return hotGoodsList;
        }

        public void setHotGoodsList(List<HotGoodsListBean> hotGoodsList) {
            this.hotGoodsList = hotGoodsList;
        }

        public List<Home_BrandListBean> getBrandList() {
            return brandList;
        }

        public void setBrandList(List<Home_BrandListBean> brandList) {
            this.brandList = brandList;
        }

        public List<TopicListBean> getTopicList() {
            return topicList;
        }

        public void setTopicList(List<TopicListBean> topicList) {
            this.topicList = topicList;
        }

        public List<CategoryListBean> getCategoryList() {
            return categoryList;
        }

        public void setCategoryList(List<CategoryListBean> categoryList) {
            this.categoryList = categoryList;
        }

        public static class BannerBean {
            /**
             * id : 1
             * ad_position_id : 1
             * media_type : 1
             * name : 合作 谁是你的菜
             * link :
             * image_url : http://yanxuan.nosdn.127.net/65091eebc48899298171c2eb6696fe27.jpg
             * content : 合作 谁是你的菜
             * end_time : 0
             * enabled : 1
             */

            private int id;
            private int ad_position_id;
            private int media_type;
            private String name;
            private String link;
            private String image_url;
            private String content;
            private int end_time;
            private int enabled;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getAd_position_id() {
                return ad_position_id;
            }

            public void setAd_position_id(int ad_position_id) {
                this.ad_position_id = ad_position_id;
            }

            public int getMedia_type() {
                return media_type;
            }

            public void setMedia_type(int media_type) {
                this.media_type = media_type;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getEnd_time() {
                return end_time;
            }

            public void setEnd_time(int end_time) {
                this.end_time = end_time;
            }

            public int getEnabled() {
                return enabled;
            }

            public void setEnabled(int enabled) {
                this.enabled = enabled;
            }
        }








        public static class CategoryListBean {
            /**
             * id : 1005000
             * name : 居家
             * goodsList : [{"id":1009024,"name":"日式和风懒人沙发","list_pic_url":"http://yanxuan.nosdn.127.net/149dfa87a7324e184c5526ead81de9ad.png","retail_price":599},{"id":1015007,"name":"典雅美式全棉刺绣抱枕","list_pic_url":"http://yanxuan.nosdn.127.net/a2045004de8a6225289376ad54317fc8.png","retail_price":59},{"id":1020000,"name":"升级款记忆绵护椎腰靠","list_pic_url":"http://yanxuan.nosdn.127.net/819fdf1f635a694166bcfdd426416e8c.png","retail_price":79},{"id":1030001,"name":"160*230羊毛手工地毯","list_pic_url":"http://yanxuan.nosdn.127.net/88dc5d80c6f84102f003ecd69c86e1cf.png","retail_price":969},{"id":1030002,"name":"160*230羊毛圈绒枪刺地毯","list_pic_url":"http://yanxuan.nosdn.127.net/8b9328496990357033d4259fda250679.png","retail_price":899},{"id":1030003,"name":"160*230羊毛手工几何地毯","list_pic_url":"http://yanxuan.nosdn.127.net/1d1ab099dc0e254c15e57302e78e200b.png","retail_price":1469},{"id":1035006,"name":"全棉单面割绒浴室地垫","list_pic_url":"http://yanxuan.nosdn.127.net/ee92704f3b8323905b51fc647823e6e5.png","retail_price":56}]
             */

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

}
