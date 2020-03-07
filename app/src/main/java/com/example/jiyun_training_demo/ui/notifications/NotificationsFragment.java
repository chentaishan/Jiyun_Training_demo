package com.example.jiyun_training_demo.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.jiyun_training_demo.R;

public class NotificationsFragment extends Fragment {

    String result ="// 20200307214130\n" +
            "// https://cdwan.cn/api/index\n" +
            "\n" +
            "{\n" +
            "  \"errno\": 0,\n" +
            "  \"errmsg\": \"\",\n" +
            "  \"data\": {\n" +
            "    \"banner\": [\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"ad_position_id\": 1,\n" +
            "        \"media_type\": 1,\n" +
            "        \"name\": \"合作 谁是你的菜\",\n" +
            "        \"link\": \"\",\n" +
            "        \"image_url\": \"http://yanxuan.nosdn.127.net/65091eebc48899298171c2eb6696fe27.jpg\",\n" +
            "        \"content\": \"合作 谁是你的菜\",\n" +
            "        \"end_time\": 0,\n" +
            "        \"enabled\": 1\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"ad_position_id\": 1,\n" +
            "        \"media_type\": 1,\n" +
            "        \"name\": \"活动 美食节\",\n" +
            "        \"link\": \"\",\n" +
            "        \"image_url\": \"http://yanxuan.nosdn.127.net/bff2e49136fcef1fd829f5036e07f116.jpg\",\n" +
            "        \"content\": \"活动 美食节\",\n" +
            "        \"end_time\": 0,\n" +
            "        \"enabled\": 1\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 3,\n" +
            "        \"ad_position_id\": 1,\n" +
            "        \"media_type\": 1,\n" +
            "        \"name\": \"活动 母亲节\",\n" +
            "        \"link\": \"\",\n" +
            "        \"image_url\": \"http://yanxuan.nosdn.127.net/8e50c65fda145e6dd1bf4fb7ee0fcecc.jpg\",\n" +
            "        \"content\": \"活动 母亲节\",\n" +
            "        \"end_time\": 0,\n" +
            "        \"enabled\": 1\n" +
            "      }\n" +
            "    ],\n" +
            "    \"channel\": [\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"name\": \"居家\",\n" +
            "        \"url\": \"/pages/category/category?id=1005000\",\n" +
            "        \"icon_url\": \"http://ac-3yr0g9cz.clouddn.com/c031ea3cf575f885cd1c.png\",\n" +
            "        \"sort_order\": 1\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"name\": \"餐厨\",\n" +
            "        \"url\": \"/pages/category/category?id=1005001\",\n" +
            "        \"icon_url\": \"http://ac-3yr0g9cz.clouddn.com/4fbe8913819b017ebe1b.png\",\n" +
            "        \"sort_order\": 2\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 3,\n" +
            "        \"name\": \"配件\",\n" +
            "        \"url\": \"/pages/category/category?id=1008000\",\n" +
            "        \"icon_url\": \"http://ac-3yr0g9cz.clouddn.com/e8070853e6c6f5627713.png\",\n" +
            "        \"sort_order\": 3\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 4,\n" +
            "        \"name\": \"服装\",\n" +
            "        \"url\": \"/pages/category/category?id=1005002\",\n" +
            "        \"icon_url\": \"http://ac-3yr0g9cz.clouddn.com/4fa3c0c72964901c5a45.png\",\n" +
            "        \"sort_order\": 4\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 5,\n" +
            "        \"name\": \"志趣\",\n" +
            "        \"url\": \"/pages/category/category?id=1019000\",\n" +
            "        \"icon_url\": \"http://ac-3yr0g9cz.clouddn.com/da8716daa0ede53a9bb8.png\",\n" +
            "        \"sort_order\": 5\n" +
            "      }\n" +
            "    ],\n" +
            "    \"newGoodsList\": [\n" +
            "      {\n" +
            "        \"id\": 1116011,\n" +
            "        \"name\": \"蔓越莓曲奇 200克\",\n" +
            "        \"list_pic_url\": \"http://yanxuan.nosdn.127.net/767b370d07f3973500db54900bcbd2a7.png\",\n" +
            "        \"retail_price\": 36\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1127047,\n" +
            "        \"name\": \"趣味粉彩系列笔记本\",\n" +
            "        \"list_pic_url\": \"http://yanxuan.nosdn.127.net/6c03ca93d8fe404faa266ea86f3f1e43.png\",\n" +
            "        \"retail_price\": 29\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1134030,\n" +
            "        \"name\": \"简约知性记忆棉坐垫\",\n" +
            "        \"list_pic_url\": \"http://yanxuan.nosdn.127.net/aa49dfe878becf768eddc4c1636643a6.png\",\n" +
            "        \"retail_price\": 46\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1134032,\n" +
            "        \"name\": \"趣味粉彩系列记忆棉坐垫\",\n" +
            "        \"list_pic_url\": \"http://yanxuan.nosdn.127.net/8b30eeb17c831eba08b97bdcb4c46a8e.png\",\n" +
            "        \"retail_price\": 49\n" +
            "      }\n" +
            "    ],\n" +
            "    \"hotGoodsList\": [\n" +
            "      {\n" +
            "        \"id\": 1006013,\n" +
            "        \"name\": \"双宫茧桑蚕丝被 空调被\",\n" +
            "        \"list_pic_url\": \"http://yanxuan.nosdn.127.net/583812520c68ca7995b6fac4c67ae2c7.png\",\n" +
            "        \"retail_price\": 699,\n" +
            "        \"goods_brief\": \"一级桑蚕丝，吸湿透气柔软\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1009012,\n" +
            "        \"name\": \"可水洗舒柔丝羽绒枕\",\n" +
            "        \"list_pic_url\": \"http://yanxuan.nosdn.127.net/a196b367f23ccfd8205b6da647c62b84.png\",\n" +
            "        \"retail_price\": 59,\n" +
            "        \"goods_brief\": \"超细纤维，蓬松轻盈回弹\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1011004,\n" +
            "        \"name\": \"色织精梳AB纱格纹空调被\",\n" +
            "        \"list_pic_url\": \"http://yanxuan.nosdn.127.net/0984c9388a2c3fd2335779da904be393.png\",\n" +
            "        \"retail_price\": 199,\n" +
            "        \"goods_brief\": \"加大加厚，双色精彩\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"brandList\": [\n" +
            "      {\n" +
            "        \"id\": 1026000,\n" +
            "        \"name\": \"CK制造商\",\n" +
            "        \"list_pic_url\": \"http://yanxuan.nosdn.127.net/658f09b7ec522d31742b47b914d64338.png\",\n" +
            "        \"simple_desc\": \"严选寻访Calvin Klein品牌的制造商，\\n深入世界领带第一生产地，设计与品质并重，\\n致力于给消费者带来优质典雅的服饰用品。\",\n" +
            "        \"pic_url\": \"http://yanxuan.nosdn.127.net/fb139c9f11a10deb41beeb42aaad488e.png\",\n" +
            "        \"sort_order\": 1,\n" +
            "        \"is_show\": 1,\n" +
            "        \"floor_price\": 39,\n" +
            "        \"app_list_pic_url\": \"http://yanxuan.nosdn.127.net/658f09b7ec522d31742b47b914d64338.png\",\n" +
            "        \"is_new\": 1,\n" +
            "        \"new_pic_url\": \"http://yanxuan.nosdn.127.net/76638fb8e6990aadf837ce761c3b7399.jpg\",\n" +
            "        \"new_sort_order\": 1\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1001000,\n" +
            "        \"name\": \"MUJI制造商\",\n" +
            "        \"list_pic_url\": \"http://yanxuan.nosdn.127.net/1541445967645114dd75f6b0edc4762d.png\",\n" +
            "        \"simple_desc\": \"严选精选了MUJI制造商和生产原料，\\n用几乎零利润的价格，剔除品牌溢价，\\n让用户享受原品牌的品质生活。\",\n" +
            "        \"pic_url\": \"http://yanxuan.nosdn.127.net/4ea3f1e60dd77c45c218e503d721a1ed.jpg\",\n" +
            "        \"sort_order\": 2,\n" +
            "        \"is_show\": 1,\n" +
            "        \"floor_price\": 12.9,\n" +
            "        \"app_list_pic_url\": \"http://yanxuan.nosdn.127.net/1541445967645114dd75f6b0edc4762d.png\",\n" +
            "        \"is_new\": 1,\n" +
            "        \"new_pic_url\": \"http://yanxuan.nosdn.127.net/4ea3f1e60dd77c45c218e503d721a1ed.jpg\",\n" +
            "        \"new_sort_order\": 2\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1024000,\n" +
            "        \"name\": \"WMF制造商\",\n" +
            "        \"list_pic_url\": \"http://yanxuan.nosdn.127.net/2018e9ac91ec37d9aaf437a1fd5d7070.png\",\n" +
            "        \"simple_desc\": \"严选找寻德国百年高端厨具WMF的制造商，\\n选择拥有14年经验的不锈钢生产工厂，\\n为你甄选事半功倍的优质厨具。\",\n" +
            "        \"pic_url\": \"http://yanxuan.nosdn.127.net/2a2ae0d49043e525db8d0d8d84460ac8.png\",\n" +
            "        \"sort_order\": 8,\n" +
            "        \"is_show\": 1,\n" +
            "        \"floor_price\": 9.9,\n" +
            "        \"app_list_pic_url\": \"http://yanxuan.nosdn.127.net/2018e9ac91ec37d9aaf437a1fd5d7070.png\",\n" +
            "        \"is_new\": 1,\n" +
            "        \"new_pic_url\": \"http://yanxuan.nosdn.127.net/abcfa79205679db51198adc19c184dd1.jpg\",\n" +
            "        \"new_sort_order\": 3\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1001038,\n" +
            "        \"name\": \"Coach制造商\",\n" +
            "        \"list_pic_url\": \"http://yanxuan.nosdn.127.net/1b1cc16135fd8467d40983f75f644127.png\",\n" +
            "        \"simple_desc\": \"严选为制作高品质高颜值皮具配件，\\n由Coach、MK等品牌制造商生产，\\n由严选360度全程监制，给你带来优质皮具。\",\n" +
            "        \"pic_url\": \"http://yanxuan.nosdn.127.net/c933a662bb79b2a47280363e35ab994b.png\",\n" +
            "        \"sort_order\": 3,\n" +
            "        \"is_show\": 1,\n" +
            "        \"floor_price\": 49,\n" +
            "        \"app_list_pic_url\": \"http://yanxuan.nosdn.127.net/1b1cc16135fd8467d40983f75f644127.png\",\n" +
            "        \"is_new\": 1,\n" +
            "        \"new_pic_url\": \"http://yanxuan.nosdn.127.net/b5cd73d3b310bad02539412f064d4ea1.jpg\",\n" +
            "        \"new_sort_order\": 10\n" +
            "      }\n" +
            "    ],\n" +
            "    \"topicList\": [\n" +
            "      {\n" +
            "        \"id\": 314,\n" +
            "        \"title\": \"关爱他成长的每一个足迹\",\n" +
            "        \"content\": \"<img src=\\\"//yanxuan.nosdn.127.net/75c55a13fde5eb2bc2dd6813b4c565cc.jpg\\\">\\n    <img src=\\\"//yanxuan.nosdn.127.net/e27e1de2b271a28a21c10213b9df7e95.jpg\\\">\\n    <img src=\\\"//yanxuan.nosdn.127.net/9d413d1d28f753cb19096b533d53418d.jpg\\\">\\n    <img src=\\\"//yanxuan.nosdn.127.net/64b0f2f350969e9818a3b6c43c217325.jpg\\\">\\n    <img src=\\\"//yanxuan.nosdn.127.net/a668e6ae7f1fa45565c1eac221787570.jpg\\\">\\n    <img src=\\\"//yanxuan.nosdn.127.net/0d4004e19728f2707f08f4be79bbc774.jpg\\\">\\n    <img src=\\\"//yanxuan.nosdn.127.net/79ee021bbe97de7ecda691de6787241f.jpg\\\">\",\n" +
            "        \"avatar\": \"https://yanxuan.nosdn.127.net/14943186689221563.png\",\n" +
            "        \"item_pic_url\": \"https://yanxuan.nosdn.127.net/14943267735961674.jpg\",\n" +
            "        \"subtitle\": \"专业运动品牌同厂，毛毛虫鞋买二送一\",\n" +
            "        \"topic_category_id\": 2,\n" +
            "        \"price_info\": 0,\n" +
            "        \"read_count\": \"6.4k\",\n" +
            "        \"scene_pic_url\": \"https://yanxuan.nosdn.127.net/14943267735961674.jpg\",\n" +
            "        \"topic_template_id\": 0,\n" +
            "        \"topic_tag_id\": 0,\n" +
            "        \"sort_order\": 1,\n" +
            "        \"is_show\": 1\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 313,\n" +
            "        \"title\": \"一次解决5个节日送礼难题\",\n" +
            "        \"content\": \"<img src=\\\"//yanxuan.nosdn.127.net/75c55a13fde5eb2bc2dd6813b4c565cc.jpg\\\">\\n    <img src=\\\"//yanxuan.nosdn.127.net/e27e1de2b271a28a21c10213b9df7e95.jpg\\\">\\n    <img src=\\\"//yanxuan.nosdn.127.net/9d413d1d28f753cb19096b533d53418d.jpg\\\">\\n    <img src=\\\"//yanxuan.nosdn.127.net/64b0f2f350969e9818a3b6c43c217325.jpg\\\">\\n    <img src=\\\"//yanxuan.nosdn.127.net/a668e6ae7f1fa45565c1eac221787570.jpg\\\">\\n    <img src=\\\"//yanxuan.nosdn.127.net/0d4004e19728f2707f08f4be79bbc774.jpg\\\">\\n    <img src=\\\"//yanxuan.nosdn.127.net/79ee021bbe97de7ecda691de6787241f.jpg\\\">\",\n" +
            "        \"avatar\": \"https://yanxuan.nosdn.127.net/14942967243991290.png\",\n" +
            "        \"item_pic_url\": \"https://yanxuan.nosdn.127.net/14942996754171334.jpg\",\n" +
            "        \"subtitle\": \"这些就是他们想要的礼物清单\",\n" +
            "        \"topic_category_id\": 0,\n" +
            "        \"price_info\": 59.9,\n" +
            "        \"read_count\": \"7.8k\",\n" +
            "        \"scene_pic_url\": \"https://yanxuan.nosdn.127.net/14942996754171334.jpg\",\n" +
            "        \"topic_template_id\": 0,\n" +
            "        \"topic_tag_id\": 0,\n" +
            "        \"sort_order\": 0,\n" +
            "        \"is_show\": 1\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 300,\n" +
            "        \"title\": \"秒杀化学洗涤剂的纯天然皂\",\n" +
            "        \"content\": \"<img src=\\\"//yanxuan.nosdn.127.net/75c55a13fde5eb2bc2dd6813b4c565cc.jpg\\\">\\n    <img src=\\\"//yanxuan.nosdn.127.net/e27e1de2b271a28a21c10213b9df7e95.jpg\\\">\\n    <img src=\\\"//yanxuan.nosdn.127.net/9d413d1d28f753cb19096b533d53418d.jpg\\\">\\n    <img src=\\\"//yanxuan.nosdn.127.net/64b0f2f350969e9818a3b6c43c217325.jpg\\\">\\n    <img src=\\\"//yanxuan.nosdn.127.net/a668e6ae7f1fa45565c1eac221787570.jpg\\\">\\n    <img src=\\\"//yanxuan.nosdn.127.net/0d4004e19728f2707f08f4be79bbc774.jpg\\\">\\n    <img src=\\\"//yanxuan.nosdn.127.net/79ee021bbe97de7ecda691de6787241f.jpg\\\">\",\n" +
            "        \"avatar\": \"https://yanxuan.nosdn.127.net/14939843011001088.png\",\n" +
            "        \"item_pic_url\": \"https://yanxuan.nosdn.127.net/14939843143621089.jpg\",\n" +
            "        \"subtitle\": \"前段时间有朋友跟我抱怨，和婆婆住到一起才发现生活理念有太多不和。别的不提，光是洗...\",\n" +
            "        \"topic_category_id\": 1,\n" +
            "        \"price_info\": 0,\n" +
            "        \"read_count\": \"15.3k\",\n" +
            "        \"scene_pic_url\": \"https://yanxuan.nosdn.127.net/14939843143621089.jpg\",\n" +
            "        \"topic_template_id\": 0,\n" +
            "        \"topic_tag_id\": 0,\n" +
            "        \"sort_order\": 0,\n" +
            "        \"is_show\": 1\n" +
            "      }\n" +
            "    ],\n" +
            "    \"categoryList\": [\n" +
            "      {\n" +
            "        \"id\": 1005000,\n" +
            "        \"name\": \"居家\",\n" +
            "        \"goodsList\": [\n" +
            "          {\n" +
            "            \"id\": 1009024,\n" +
            "            \"name\": \"日式和风懒人沙发\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/149dfa87a7324e184c5526ead81de9ad.png\",\n" +
            "            \"retail_price\": 599\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1015007,\n" +
            "            \"name\": \"典雅美式全棉刺绣抱枕\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/a2045004de8a6225289376ad54317fc8.png\",\n" +
            "            \"retail_price\": 59\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1020000,\n" +
            "            \"name\": \"升级款记忆绵护椎腰靠\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/819fdf1f635a694166bcfdd426416e8c.png\",\n" +
            "            \"retail_price\": 79\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1030001,\n" +
            "            \"name\": \"160*230羊毛手工地毯\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/88dc5d80c6f84102f003ecd69c86e1cf.png\",\n" +
            "            \"retail_price\": 969\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1030002,\n" +
            "            \"name\": \"160*230羊毛圈绒枪刺地毯\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/8b9328496990357033d4259fda250679.png\",\n" +
            "            \"retail_price\": 899\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1030003,\n" +
            "            \"name\": \"160*230羊毛手工几何地毯\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/1d1ab099dc0e254c15e57302e78e200b.png\",\n" +
            "            \"retail_price\": 1469\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1035006,\n" +
            "            \"name\": \"全棉单面割绒浴室地垫\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/ee92704f3b8323905b51fc647823e6e5.png\",\n" +
            "            \"retail_price\": 56\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1005001,\n" +
            "        \"name\": \"餐厨\",\n" +
            "        \"goodsList\": [\n" +
            "          {\n" +
            "            \"id\": 1023003,\n" +
            "            \"name\": \"100年传世珐琅锅 全家系列\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/c39d54c06a71b4b61b6092a0d31f2335.png\",\n" +
            "            \"retail_price\": 398\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1025005,\n" +
            "            \"name\": \"100年传世珐琅锅\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/49e26f00ca4d0ce00f9960d22c936738.png\",\n" +
            "            \"retail_price\": 268\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1038004,\n" +
            "            \"name\": \"100年传世珐琅锅 马卡龙系列\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/4d3d3eaeb872860539d7faa59f9f84e9.png\",\n" +
            "            \"retail_price\": 359\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1051000,\n" +
            "            \"name\": \"Carat钻石炒锅30cm\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/e564410546a11ddceb5a82bfce8da43d.png\",\n" +
            "            \"retail_price\": 180\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1051001,\n" +
            "            \"name\": \"Carat钻石煎锅28cm\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/f53ed57d9e23fda7e24dfd0e0a50c5d1.png\",\n" +
            "            \"retail_price\": 159\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1051002,\n" +
            "            \"name\": \"Carat钻石汤锅24cm\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/56f4b4753392d27c0c2ccceeb579ed6f.png\",\n" +
            "            \"retail_price\": 228\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1051003,\n" +
            "            \"name\": \"Carat钻石奶锅18cm\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/6a54ccc389afb2459b163245bbb2c978.png\",\n" +
            "            \"retail_price\": 148\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1005002,\n" +
            "        \"name\": \"饮食\",\n" +
            "        \"goodsList\": [\n" +
            "          {\n" +
            "            \"id\": 1045000,\n" +
            "            \"name\": \"绿茶蛋黄酥 200克/4枚入\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/b2adc3fd9b84a289a1be03e8ee400e61.png\",\n" +
            "            \"retail_price\": 28\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1070000,\n" +
            "            \"name\": \"星云酥 180克/3颗\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/8392725765cdd57fdae3f173877f4bda.png\",\n" +
            "            \"retail_price\": 26\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1111007,\n" +
            "            \"name\": \"妙曲奇遇记曲奇礼盒 520克\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/8d228f767b136a67aaf2cbbf6deb46fa.png\",\n" +
            "            \"retail_price\": 78\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1116011,\n" +
            "            \"name\": \"蔓越莓曲奇 200克\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/767b370d07f3973500db54900bcbd2a7.png\",\n" +
            "            \"retail_price\": 36\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1134036,\n" +
            "            \"name\": \"凤梨酥 360克\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/9356cc27b22bd47ad43913d13226555f.png\",\n" +
            "            \"retail_price\": 38\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1143018,\n" +
            "            \"name\": \"粽情乡思端午粽礼盒 640克\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/d1fd69cee4990f4de1109baef30efeeb.png\",\n" +
            "            \"retail_price\": 68\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1143019,\n" +
            "            \"name\": \"粽夏冰晶端午粽礼盒 480克\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/277b07c1e5e6fb57cf9ca47fcd3903d5.png\",\n" +
            "            \"retail_price\": 98\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1008000,\n" +
            "        \"name\": \"配件\",\n" +
            "        \"goodsList\": [\n" +
            "          {\n" +
            "            \"id\": 1085019,\n" +
            "            \"name\": \"20寸 纯PC“铝框”（非全铝）登机箱\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/65c955a7a98e84d44ca30bb88a591eac.png\",\n" +
            "            \"retail_price\": 349\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1086052,\n" +
            "            \"name\": \"20寸 铝镁合金登机箱\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/93171a281c4ed272c007a050816e6f6c.png\",\n" +
            "            \"retail_price\": 859\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1113019,\n" +
            "            \"name\": \"20寸 PC膜拉链登机箱\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/ad504bb389039ff35c4cd6ae912be87e.png\",\n" +
            "            \"retail_price\": 208\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1114011,\n" +
            "            \"name\": \"104升 纯PC拉链斜纹拉杆箱\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/196b5ce11930b4eadaec563cb0406634.png\",\n" +
            "            \"retail_price\": 299\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1143016,\n" +
            "            \"name\": \"112升 纯PC拉链斜纹拉杆箱\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/e56c6239ee4a641ce2a4565c6babb43e.png\",\n" +
            "            \"retail_price\": 319\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1152101,\n" +
            "            \"name\": \"魔兽世界 部落 奥格瑞玛 拉杆箱 可登机\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/c1c62211a17b71a634fa0c705d11fb42.png\",\n" +
            "            \"retail_price\": 888\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1156006,\n" +
            "            \"name\": \"20寸 全铝镁合金登机箱\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/ea5b0a572b35089446fba491db7fbbc3.png\",\n" +
            "            \"retail_price\": 699\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1010000,\n" +
            "        \"name\": \"服装\",\n" +
            "        \"goodsList\": [\n" +
            "          {\n" +
            "            \"id\": 1056002,\n" +
            "            \"name\": \"男式玩色内裤\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/922fdbe007033f7a88f7ebc57c3d1e75.png\",\n" +
            "            \"retail_price\": 59\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1074001,\n" +
            "            \"name\": \"男式莫代尔无痕内裤\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/73567265b04a9998f64419186ddd8531.png\",\n" +
            "            \"retail_price\": 59\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1092025,\n" +
            "            \"name\": \"Let it go男式纯棉免洗内裤\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/56a46e9a4832587471c0f9ad7c1b7d85.png\",\n" +
            "            \"retail_price\": 19.9\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1092026,\n" +
            "            \"name\": \"Let it go女式纯棉免洗内裤\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/83433f5a7ef69abda2544a53332a0fad.png\",\n" +
            "            \"retail_price\": 19.9\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1113010,\n" +
            "            \"name\": \"男式丝滑莫代尔平角内裤\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/2d0920b51331bb1636330ad8e07d1b97.png\",\n" +
            "            \"retail_price\": 59\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1113011,\n" +
            "            \"name\": \"女式丝滑莫代尔三角内裤\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/7a683f68fc988df299b5cfe6273d6fb7.png\",\n" +
            "            \"retail_price\": 49\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1127024,\n" +
            "            \"name\": \"女式无痕真丝内裤\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/0a70f12a712e90d7d93beec4f686fe8e.png\",\n" +
            "            \"retail_price\": 39\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1011000,\n" +
            "        \"name\": \"婴童\",\n" +
            "        \"goodsList\": [\n" +
            "          {\n" +
            "            \"id\": 1033000,\n" +
            "            \"name\": \"新生彩棉初衣礼盒（婴童）\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/9aab9a0bf4fef8fe3dc8c732bc22d4b7.png\",\n" +
            "            \"retail_price\": 199\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1116004,\n" +
            "            \"name\": \"条纹长袖海魂衫（男婴童）\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/14d3a47ccf52815baf6df308be6db5a6.png\",\n" +
            "            \"retail_price\": 79\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1116005,\n" +
            "            \"name\": \"条纹长袖海魂衫（女婴童）\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/71937456c3cd654f936f619201a79c09.png\",\n" +
            "            \"retail_price\": 79\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1116008,\n" +
            "            \"name\": \"棉双层纱波点娃娃裙（婴童）\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/149a09a391ea5a888debf50b9dc4ed7b.png\",\n" +
            "            \"retail_price\": 99\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1125010,\n" +
            "            \"name\": \"格纹棉质褶皱娃娃裙（婴童）\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/f82995ccb2a2f6beddd4ad794f5da2a1.png\",\n" +
            "            \"retail_price\": 159\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1125011,\n" +
            "            \"name\": \"格纹棉质衬衣（婴童）\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/be9740b734087f294f59a6560b932bc1.png\",\n" +
            "            \"retail_price\": 139\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1125026,\n" +
            "            \"name\": \"中国红满月百天礼盒\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/6308c120c441fd3e47658167ad944156.png\",\n" +
            "            \"retail_price\": 159\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1012000,\n" +
            "        \"name\": \"杂货\",\n" +
            "        \"goodsList\": [\n" +
            "          {\n" +
            "            \"id\": 1039056,\n" +
            "            \"name\": \"金属亚光钢笔\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/3e14e82a44c3a250af63df4c29c572d0.png\",\n" +
            "            \"retail_price\": 79\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1046001,\n" +
            "            \"name\": \"按动式三角中油笔\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/74583e585825ecacb11f7c53d2021e00.png\",\n" +
            "            \"retail_price\": 8.9\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1046002,\n" +
            "            \"name\": \"直杆三角中性笔\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/eb486cfe807c4fe5696aa59cbcf1f96a.png\",\n" +
            "            \"retail_price\": 9.9\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1055022,\n" +
            "            \"name\": \"磨砂杆直杆中性笔\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/c7c74a96eacb29455dbf557b840eaaf5.png\",\n" +
            "            \"retail_price\": 4.9\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1075022,\n" +
            "            \"name\": \"暗格简约钢笔\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/97ad483a94ed88216a989df83e39cbf0.png\",\n" +
            "            \"retail_price\": 39\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1092001,\n" +
            "            \"name\": \"星空原色水晶笔\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/8e35b003ce7895c39eeb073b1f61b1d7.png\",\n" +
            "            \"retail_price\": 29\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1092005,\n" +
            "            \"name\": \"木韵檀香黄铜笔\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/ab1992495e0370f09386d418ad45220d.png\",\n" +
            "            \"retail_price\": 39\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1013001,\n" +
            "        \"name\": \"洗护\",\n" +
            "        \"goodsList\": [\n" +
            "          {\n" +
            "            \"id\": 1006051,\n" +
            "            \"name\": \"皇室御用超柔毛巾\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/ad5a317216f9da495b144070ecf1f957.png\",\n" +
            "            \"retail_price\": 59\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1009027,\n" +
            "            \"name\": \"皇室御用超柔毛巾80s\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/71cfd849335c498dee3c54d1eb823c17.png\",\n" +
            "            \"retail_price\": 79\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1021000,\n" +
            "            \"name\": \"埃及进口长绒棉毛巾\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/7191f2599c7fe44ed4cff7a76e853154.png\",\n" +
            "            \"retail_price\": 39\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1021001,\n" +
            "            \"name\": \"全棉进口埃及长绒棉浴巾\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/fd5a8622ee1a7dfd4b57b938ebf25b24.png\",\n" +
            "            \"retail_price\": 99\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1111010,\n" +
            "            \"name\": \"静谧森林简欧色织提花面巾\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/ef7efe55839e66993fb604dc3c2d9410.png\",\n" +
            "            \"retail_price\": 69\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1128010,\n" +
            "            \"name\": \"趣味粉彩单面纱布亲肤毛巾\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/a84e8e6979f00efd9a728ed36b154753.png\",\n" +
            "            \"retail_price\": 29\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1128011,\n" +
            "            \"name\": \"趣味粉彩单面纱布超柔浴巾\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/d6e25ec5b4ad7aa37e077ce751b56f46.png\",\n" +
            "            \"retail_price\": 79\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1019000,\n" +
            "        \"name\": \"志趣\",\n" +
            "        \"goodsList\": [\n" +
            "          {\n" +
            "            \"id\": 1152004,\n" +
            "            \"name\": \"魔兽世界 蛋盾包 双肩包\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/8c93cef435d888bd79833777df1cd0c2.png\",\n" +
            "            \"retail_price\": 399\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1152008,\n" +
            "            \"name\": \"魔兽世界 部落 护腕 一只\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/203cb83d93606865e3ddde57b69b9e9a.png\",\n" +
            "            \"retail_price\": 29\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1152009,\n" +
            "            \"name\": \"魔兽世界 联盟 护腕 一只\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/ae6d41117717387b82dcaf1dfce0cd97.png\",\n" +
            "            \"retail_price\": 29\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1152031,\n" +
            "            \"name\": \"魔兽世界-伊利丹颈枕眼罩套装\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/fd6e78a397bd9e9804116a36f0270b0a.png\",\n" +
            "            \"retail_price\": 99\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1152095,\n" +
            "            \"name\": \"魔兽世界 联盟·暴风城 堡垒收纳盒\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/c86b49f635fa141decebabbd0966a6ef.png\",\n" +
            "            \"retail_price\": 499\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1152097,\n" +
            "            \"name\": \"魔兽世界 雷霆之怒逐风者的祝福之剑 雨伞\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/532836444ae5eaec40b5810ca4f9b1e6.png\",\n" +
            "            \"retail_price\": 399\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1152100,\n" +
            "            \"name\": \"魔兽世界 部落·奥格瑞玛 堡垒收纳盒\",\n" +
            "            \"list_pic_url\": \"http://yanxuan.nosdn.127.net/a667c4fbbd9c499c0733539d7e986617.png\",\n" +
            "            \"retail_price\": 499\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";
    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(result);
            }
        });
        textView.setText(result);
        return root;
    }
}
