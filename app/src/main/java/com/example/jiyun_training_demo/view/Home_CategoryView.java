package com.example.jiyun_training_demo.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.SparseArray;
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
 * 分类卡片
 * 功能：
 * 实现动态列数的网格布局
 * 实现头部文字类型显示
 * 实现item的点击事件
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

    public void initTitleView(String name) {

        TextView textView = new TextView(getContext());
        textView.setText(name);
        textView.setGravity(Gravity.CENTER);
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 44, 0, 44);
        textView.setLayoutParams(layoutParams);
        addView(textView);


    }


    private int columnNum = 2;
    private static int imageWidth = 0;
    private LinearLayout rowLinearlayout;
    int totalDividerWidth = 30 * 3;

    /**
     * 设置所有间隔距离，方便计算item的宽度
     *
     * @param totalDividerWidth
     */
    public void setTotalDividerWidth(int totalDividerWidth) {
        this.totalDividerWidth = totalDividerWidth;
    }

    /**
     * 设置列数
     *
     * @param columnNum
     */
    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public <T> void initGridList(final List<T> listBeans, IUpdateUIListener iUpdateUIListener) throws IllegalAccessException {
        if (columnNum == 0) {
            throw new IllegalAccessException("请设置列数！");
        }
        this.iUpdateUIListener = iUpdateUIListener;
        imageWidth = SystemUtils.getScreenWidth(getContext()) - totalDividerWidth;
        imageWidth = imageWidth / columnNum;
        removeAllViews();
        for (int i = 0; i < listBeans.size(); i++) {

            T t = listBeans.get(i);

            View item = initItemView(t);

            if (i % columnNum == 0) {
                rowLinearlayout = new LinearLayout(getContext());
                rowLinearlayout.setOrientation(HORIZONTAL);
                LayoutParams layout = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layout.setMargins(30, 0, 0, 0);
                rowLinearlayout.setLayoutParams(layout);

                rowLinearlayout.addView(item);

                addView(rowLinearlayout);

            } else {
                //添加间隔线
                View view = new View(getContext());
                view.setLayoutParams(new LayoutParams(30, ViewGroup.LayoutParams.MATCH_PARENT));
                rowLinearlayout.addView(view);
                rowLinearlayout.addView(item);
            }

        }

    }

    private <T> View initItemView(final T t) {
        //获取子布局，设置宽度 高度

        final View item = LayoutInflater.from(getContext()).inflate(R.layout.category_goods_item, null);
        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(imageWidth, ViewGroup.LayoutParams.WRAP_CONTENT);
        item.setLayoutParams(linearParams);

        // 设置图片宽高 正方形
        ImageView imageView = item.findViewById(R.id.image);

        LinearLayout.LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
        layoutParams.width = imageWidth;
        layoutParams.height = imageWidth;

        imageView.setBackgroundColor(Color.parseColor("#F0EBE9"));
        imageView.setLayoutParams(layoutParams);

        TextView title = item.findViewById(R.id.title);
        TextView pTitle = item.findViewById(R.id.price);
        if (iUpdateUIListener != null) {

            iUpdateUIListener.setItem(t, imageView, title, pTitle);
        }

        item.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iUpdateUIListener != null) {

                    iUpdateUIListener.itemClick(t);
                }
            }
        });

        return item;
    }

    IUpdateUIListener iUpdateUIListener;

    public interface IUpdateUIListener<T> {

        void setItem(T t, ImageView img, TextView title, TextView price);

        void itemClick(T t);
    }


}
