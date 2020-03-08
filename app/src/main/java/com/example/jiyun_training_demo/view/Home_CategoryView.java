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
import com.example.jiyun_training_demo.bean.CategoryListBean;
import com.example.jiyun_training_demo.bean.HotGoodsListBean;
import com.example.jiyun_training_demo.utils.SystemUtils;

import java.util.List;

/**
 *  分类卡片
 */
public class Home_CategoryView extends LinearLayout {
    public Home_CategoryView(Context context) {
        super(context);

        setOrientation(VERTICAL);
    }

    public Home_CategoryView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
    }

    public Home_CategoryView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(VERTICAL);
    }

    public void initView(CategoryListBean categoryListBean) {

        TextView textView = new TextView(getContext());
        textView.setText(categoryListBean.getName());
        textView.setGravity(Gravity.CENTER);
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0,44,0,44);
        textView.setLayoutParams(layoutParams);
        addView(textView);


        initList(categoryListBean.getGoodsList());

    }

    int imageWidth = 0;
    LinearLayout rowLinearlayout;

    private void initList(final List<CategoryListBean.GoodsListBean> goodsListBeans) {
        imageWidth = SystemUtils.getScreenWidth(getContext())-(30*3);
        imageWidth= imageWidth/2;
        for (int i = 0; i < goodsListBeans.size(); i++) {


            CategoryListBean.GoodsListBean hotGoodsListBean = goodsListBeans.get(i);

            //获取子布局，设置宽度 高度
            View item = LayoutInflater.from(getContext()).inflate(R.layout.category_goods_item, null);
            LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(imageWidth, ViewGroup.LayoutParams.WRAP_CONTENT);

            item.setLayoutParams(linearParams);

            // 设置图片宽高 正方形
            ImageView imageView = item.findViewById(R.id.image);

            LinearLayout.LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
            layoutParams.width =imageWidth;
            layoutParams.height = imageWidth;

            imageView.setBackgroundColor(Color.parseColor("#F0EBE9"));
            imageView.setLayoutParams(layoutParams);

            TextView title = item.findViewById(R.id.title);
            TextView pTitle = item.findViewById(R.id.price);

            Glide.with(getContext()).load(hotGoodsListBean.getList_pic_url()).into(imageView);
            title.setText(hotGoodsListBean.getName());
            pTitle.setText(hotGoodsListBean.getRetail_price() + "元起");

            if (i%2==0){
                rowLinearlayout = new LinearLayout(getContext());
                rowLinearlayout.setOrientation(HORIZONTAL);
                LayoutParams layout = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layout.setMargins(30,0,0,0);
                rowLinearlayout.setLayoutParams(layout);

                rowLinearlayout.addView(item);

                addView(rowLinearlayout);

            }else{
                //添加间隔线
                View view = new View(getContext());
                view.setLayoutParams(new LayoutParams(30, ViewGroup.LayoutParams.MATCH_PARENT));
                view.setBackgroundColor(Color.parseColor("#ffffff"));
                rowLinearlayout. addView(view);

                rowLinearlayout.addView(item);


            }




        }

    }




}
