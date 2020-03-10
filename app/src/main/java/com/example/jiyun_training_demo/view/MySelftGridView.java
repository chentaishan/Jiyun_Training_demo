package com.example.jiyun_training_demo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.jiyun_training_demo.R;
import com.example.jiyun_training_demo.bean.CataLogItemBean;
import com.example.jiyun_training_demo.utils.SystemUtils;

import java.util.List;

public class MySelftGridView extends LinearLayout
{

    private LinearLayout linearLayout;

    public MySelftGridView(Context context) {
        super(context);
        init();
    }

    public MySelftGridView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MySelftGridView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }



    private void init() {

        setOrientation(VERTICAL);
    }

    /**
     * 列数
     */
    int columnuNum = 3;
    int itemWidth =0;

    private static final String TAG = "MySelftGridView";

    public void initMyGridView(List<CataLogItemBean.DataBean.CurrentCategoryBean.SubCategoryListBean>  itemList){

        itemWidth = (SystemUtils.getScreenWidth(getContext())-SystemUtils.dip2px(getContext(),100f))/columnuNum;

        Log.d(TAG, "initMyGridView: "+itemWidth);

        for (int i = 0; i < itemList.size(); i++) {

            CataLogItemBean.DataBean.CurrentCategoryBean.SubCategoryListBean subCategoryListBean = itemList.get(i);

            View item = LayoutInflater.from(getContext()).inflate(R.layout.sort_item,null);
            ImageView img  = item.findViewById(R.id.img);
            TextView subTitle  = item.findViewById(R.id.sub_title);
            Glide.with(getContext()).load(subCategoryListBean.getWap_banner_url()).into(img);
            subTitle.setText(subCategoryListBean.getName());

            LayoutParams layoutParams =  new  LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
            // 为了item 等分
//            layoutParams.weight= 1;
            layoutParams.width = itemWidth;
            item.setLayoutParams(layoutParams);


            if (i%columnuNum==0){

                linearLayout = new LinearLayout(getContext());
                linearLayout.setOrientation(HORIZONTAL);
                linearLayout.addView(item);


                addView(linearLayout);
            }else{


                linearLayout.addView(item);
            }
        }

    }

}
