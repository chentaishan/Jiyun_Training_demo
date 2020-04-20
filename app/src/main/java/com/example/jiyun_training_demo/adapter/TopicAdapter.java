package com.example.jiyun_training_demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jiyun_training_demo.R;
import com.example.jiyun_training_demo.bean.TopicBean;
import com.example.jiyun_training_demo.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TopicAdapter extends BaseAdapter<TopicBean.DataBean> {

    public TopicAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.topic_list_item;
    }

    @Override
    protected void bindData(BaseViewHolder baseViewHolder, TopicBean.DataBean dataBean) {
//        img = itemView.findViewById(R.id.image);
        ImageView img = (ImageView) baseViewHolder.getViewById(R.id.image);
        TextView title = (TextView) baseViewHolder.getViewById(R.id.title);
        TextView stitle = (TextView) baseViewHolder.getViewById(R.id.sub_title);
        TextView ptitle = (TextView) baseViewHolder.getViewById(R.id.price_info);

        Glide.with(context).load(dataBean.getScene_pic_url()).into(img);
        title.setText(dataBean.getTitle());
        stitle.setText(dataBean.getSubtitle());
        ptitle.setText(StringUtils.filterStr(dataBean.getPrice_info())+"元起");

    }

}
