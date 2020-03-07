package com.example.jiyun_training_demo.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.jiyun_training_demo.R;
import com.example.jiyun_training_demo.bean.Home_BrandListBean;
import com.example.jiyun_training_demo.bean.Home_ChannelBean;
import com.example.jiyun_training_demo.utils.SystemUtils;

import java.util.List;

/**
 * 品牌制造商
 */
public class HomeSubTwo extends LinearLayout {
    public HomeSubTwo(Context context) {
        super(context);

        initView();
    }

    public HomeSubTwo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public HomeSubTwo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {

        TextView textView = new TextView(getContext());
        textView.setText("品牌制造商");
        textView.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0,44,0,44);
        textView.setLayoutParams(layoutParams);

        addView(textView);


    }

    int columnNum = 2;
    LinearLayout rowLinearLayout;

    public void initGird(final List<Home_BrandListBean> home_brandListBeans) {

        for (int i = 0; i < home_brandListBeans.size(); i++) {

            Home_BrandListBean home_brandListBean = home_brandListBeans.get(i);

            View item = LayoutInflater.from(getContext()).inflate(R.layout.brand_item, null);


            int width  =(SystemUtils.getScreenWidth(getContext())-4)/2 ;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width,width*2/3);

//            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) item.getLayoutParams();
//            layoutParams.width = (SystemUtils.getScreenWidth(getContext())-4)/2;
//
            item.setLayoutParams(layoutParams);

            ImageView imageView = item.findViewById(R.id.image);
            TextView title = item.findViewById(R.id.title);
            TextView subTitle = item.findViewById(R.id.sub_title);

            Glide.with(getContext()).load(home_brandListBean.getNew_pic_url()).into(imageView);
            title.setText(home_brandListBean.getName());
            subTitle.setText(home_brandListBean.getFloor_price() + "元起");
            if (i % columnNum == 0) {

                rowLinearLayout = new LinearLayout(getContext());
                rowLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                rowLinearLayout.setOrientation(HORIZONTAL);
                rowLinearLayout.addView(item);
                FrameLayout.LayoutParams divivParams = new FrameLayout.LayoutParams(4, ViewGroup.LayoutParams.MATCH_PARENT);
                View line = new View(getContext());
                line.setLayoutParams(divivParams);
                line.setBackgroundColor(Color.parseColor("#ffffff"));
                addView(line);
                addView(rowLinearLayout);
            } else {
                if (rowLinearLayout != null) {
                    rowLinearLayout.addView(item);
                }

            }
        }

    }


//    public void initGridView(final List<Home_BrandListBean> home_brandListBeans) {
//        if (home_brandListBeans == null) {
//            return;
//        }
//        GridView gridView = new GridView(getContext());
//        addView(gridView);
//        gridView.setNumColumns(2);
//
//        LinearLayout.LayoutParams layoutParams = (LayoutParams) getLayoutParams();
//        layoutParams.height = 1800;
//        setLayoutParams(layoutParams);
//
//        gridView.setAdapter(new BaseAdapter() {
//
//            @Override
//            public int getCount() {
//                return home_brandListBeans.size();
//            }
//
//            @Override
//            public Object getItem(int position) {
//                return home_brandListBeans.get(position);
//            }
//
//            @Override
//            public long getItemId(int position) {
//                return position;
//            }
//
//            @NonNull
//            @Override
//            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//                if (convertView == null) {
//                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.brand_item, parent, false);
//                }
//                Home_BrandListBean item = home_brandListBeans.get(position);
//                ImageView imageView = convertView.findViewById(R.id.image);
//                TextView title = convertView.findViewById(R.id.title);
//                TextView subTitle = convertView.findViewById(R.id.sub_title);
//                Glide.with(getContext()).load(item.getNew_pic_url()).into(imageView);
//                title.setText(item.getName());
//                subTitle.setText(item.getFloor_price() + "元起");
//                return convertView;
//            }
//        });
//    }


}
