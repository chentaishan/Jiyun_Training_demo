package com.example.jiyun_training_demo.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.jiyun_training_demo.R;
import com.example.jiyun_training_demo.bean.HotGoodsListBean;
import com.example.jiyun_training_demo.bean.TopicListBean;
import com.example.jiyun_training_demo.utils.SystemUtils;

import java.util.List;

/**
 * 专题精选
 */
public class Home_TopicGoods extends LinearLayout {
    public Home_TopicGoods(Context context) {
        super(context);
        initView();
    }

    public Home_TopicGoods(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public Home_TopicGoods(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {

        TextView textView = new TextView(getContext());
        textView.setText("专题精选");
        textView.setGravity(Gravity.CENTER);
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0,44,0,44);
        textView.setLayoutParams(layoutParams);
        addView(textView);


    }


    public void initList(final List<TopicListBean> topicListBeanList) {
        if(topicListBeanList==null){
            return;
        }

        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(getContext());

        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(HORIZONTAL);
        horizontalScrollView.addView(linearLayout);
        addView(horizontalScrollView);

        for (int i = 0; i < topicListBeanList.size(); i++) {

            TopicListBean hotGoodsListBean = topicListBeanList.get(i);

            View item = LayoutInflater.from(getContext()).inflate(R.layout.topic_goods_item, null);

            int width = SystemUtils.getScreenWidth(getContext())-90;
            LayoutParams layoutParams = new LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(30,0,0,0);
            item.setLayoutParams(layoutParams);


            ImageView imageView = item.findViewById(R.id.image);
            TextView title = item.findViewById(R.id.title);
            TextView pTitle = item.findViewById(R.id.price);
            TextView stitle = item.findViewById(R.id.sub_title);

            Glide.with(getContext()).load(hotGoodsListBean.getScene_pic_url()).into(imageView);
            title.setText(hotGoodsListBean.getTitle());
            stitle.setText(hotGoodsListBean.getSubtitle());
            pTitle.setText(hotGoodsListBean.getPrice_info() + "元起");

            linearLayout.addView(item);



        }

    }




}
