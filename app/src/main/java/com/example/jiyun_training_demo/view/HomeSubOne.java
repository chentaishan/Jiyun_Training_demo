package com.example.jiyun_training_demo.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.jiyun_training_demo.bean.Home_ChannelBean;

import java.util.List;

public class HomeSubOne extends LinearLayout {
    public HomeSubOne(Context context) {
        super(context);
    }

    public HomeSubOne(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeSubOne(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        setOrientation(HORIZONTAL);

        LinearLayout.LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        layoutParams.setMargins(0, 55, 0, 55);


        setLayoutParams(layoutParams);
    }

    public void addItem(List<Home_ChannelBean> channelBeanList) {

        for (int i = 0; i < channelBeanList.size(); i++) {
            Home_ChannelBean home_channelBean = channelBeanList.get(i);

            TextView textView = new TextView(getContext());
            if (i % 2 == 0) {

                textView.setBackgroundColor(Color.parseColor("#EEE685"));
            }
            textView.setText(home_channelBean.getName());
            LayoutParams layoutParams = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.weight = 1;

            textView.setGravity(Gravity.CENTER);

            textView.setLayoutParams(layoutParams);

            addView(textView);
        }

    }


}
