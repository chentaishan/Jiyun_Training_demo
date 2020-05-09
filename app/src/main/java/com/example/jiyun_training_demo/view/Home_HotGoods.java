package com.example.jiyun_training_demo.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.jiyun_training_demo.R;
import com.example.jiyun_training_demo.bean.HotGoodsListBean;
import com.example.jiyun_training_demo.bean.NewGoodsListBean;
import com.example.jiyun_training_demo.utils.SystemUtils;

import java.util.List;

/**
 * 人气推荐
 */
public class Home_HotGoods extends LinearLayout {
    public Home_HotGoods(Context context) {
        super(context);
        initView();
    }

    public Home_HotGoods(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public Home_HotGoods(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {

        TextView textView = new TextView(getContext());
        textView.setText("人气推荐");
        textView.setGravity(Gravity.CENTER);
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0,44,0,44);
        textView.setLayoutParams(layoutParams);
        addView(textView);
        View view = new View(getContext());
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,1));
        view.setBackgroundResource(R.color.col_gray_line);
        addView(view);


    }


    public void initList(final List<HotGoodsListBean> hotGoodsListBeanList) {

        for (int i = 0; i < hotGoodsListBeanList.size(); i++) {

            HotGoodsListBean hotGoodsListBean = hotGoodsListBeanList.get(i);

            View item = LayoutInflater.from(getContext()).inflate(R.layout.hot_goods_item, null);

            ImageView imageView = item.findViewById(R.id.image);
            TextView title = item.findViewById(R.id.title);
            TextView stitle = item.findViewById(R.id.sub_title);
            TextView pTitle = item.findViewById(R.id.price);

            Glide.with(getContext()).load(hotGoodsListBean.getList_pic_url()).into(imageView);
            title.setText(hotGoodsListBean.getName());
            stitle.setText(hotGoodsListBean.getGoods_brief());
            pTitle.setText(hotGoodsListBean.getRetail_price() + "元起");
           addView(item);

            View view = new View(getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,1));
            view.setBackgroundResource(R.color.col_gray_line);
            addView(view);

        }

    }




}
